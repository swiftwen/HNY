package com.weiye.workflow.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.bpmn.diagram.ProcessDiagramGenerator;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.weiye.annotation.SystemControllerLog;
import com.weiye.config.ActivitiConfig;
import com.weiye.properties.ProcessDefine;
import com.weiye.workflow.service.WorkFlowService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * 流程定义
 * @author Liweiye
 * @date 2018年12月13日
 */
@RestController
@Api(value = "流程定义", description = "流程定义")
@RequestMapping("/processDefine")
public class ProcessDefineController {

    private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ProcessDefine processDefine;
	
	@Autowired
	private  ActivitiConfig activitiConfig;
	
    @Autowired
    private WorkFlowService workFlowService;

	@PostMapping("/deployProcess")
	@SystemControllerLog(value = "部署流程文件")
	@ApiOperation(value = "部署流程文件", httpMethod = "POST", notes = "200: 发送成功")
	public Object deployProcess(@ApiParam(value = "上传文件", required = true) @RequestParam MultipartFile file) throws IOException {
		File uploadFile = new File(processDefine.getPath() + file.getOriginalFilename());
		if (!uploadFile.getParentFile().exists()) {
			uploadFile.getParentFile().mkdirs();
		}
		FileUtils.writeByteArrayToFile(uploadFile, file.getBytes());
		InputStream inputStream = new FileInputStream(uploadFile);
		//部署流程
		activitiConfig.repositoryService().createDeployment().addInputStream(file.getOriginalFilename(), inputStream).deploy();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("httpCode", "200");
		return map;
	}

    @PostMapping("/startProcess")
    @SystemControllerLog(value = "启动流程")
    @ApiOperation(value = "启动流程", httpMethod = "POST", notes = "200: 发送成功")
    public Object startProcess(@ApiParam(value = "流程key值", required = true) @RequestParam String processKey)
            throws IOException {
        String processInstanceId = workFlowService.startWorkFlowProcess(processKey, "weiye", "1234554321", null, null);
        activitiConfig.taskService().createTaskQuery().list();
        Task task = activitiConfig.taskService().createTaskQuery().processInstanceId(processInstanceId).singleResult();
        activitiConfig.taskService().complete(task.getId());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("httpCode", "200");
        return map;
    }

    @PostMapping("/resolveException")
    @SystemControllerLog(value = "解决异常流程")
    @ApiOperation(value = "解决异常流程", httpMethod = "POST", notes = "200: 发送成功")
    public Object resolveException(@ApiParam(value = "流程实例值", required = true) @RequestParam String processInstanceId)
            throws IOException {
        workFlowService.resolveException(processInstanceId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("httpCode", "200");
        return map;
    }

    @RequestMapping(value = "/test")
    @SystemControllerLog(value = "展示流程图")
    @ApiOperation(value = "展示流程图", httpMethod = "GET", notes = "200: 发送成功")
    public void test(HttpServletResponse response,
        @ApiParam(value = "流程key值", required = true) @RequestParam String processID) throws Exception {
        String processInstanceId = processID;

        // 获取历史流程实例
        HistoricProcessInstance processInstance = activitiConfig.historyService().createHistoricProcessInstanceQuery()
                .processInstanceId(processInstanceId).singleResult();
        // 获取流程图
        BpmnModel bpmnModel = activitiConfig.repositoryService().getBpmnModel(processInstance.getProcessDefinitionId());
        ProcessEngineConfiguration processEngineConfiguration = activitiConfig.processEngineConfiguration();
        Context.setProcessEngineConfiguration((ProcessEngineConfigurationImpl) processEngineConfiguration);

        ProcessDiagramGenerator diagramGenerator = new ProcessDiagramGenerator();
        ProcessDefinitionEntity definitionEntity = (ProcessDefinitionEntity) activitiConfig.repositoryService()
                .getProcessDefinition(processInstance.getProcessDefinitionId());

        List<HistoricActivityInstance> highLightedActivitList = activitiConfig.historyService()
                .createHistoricActivityInstanceQuery()
                .processInstanceId(processInstanceId).list();
        // 高亮环节id集合
        List<String> highLightedActivitis = new ArrayList<String>();
        // 高亮线路id集合
        List<String> highLightedFlows = getHighLightedFlows(definitionEntity, highLightedActivitList);
        if (!CollectionUtils.isEmpty(highLightedActivitList)) {
        highLightedActivitis.add(highLightedActivitList.get(highLightedActivitis.size() - 1).getActivityId());
        }
        // for (HistoricActivityInstance tempActivity : highLightedActivitList) {
        // String activityId = tempActivity.getActivityId();
        // highLightedActivitis.add(activityId);
        // }

        // 中文显示的是口口口，设置字体就好了
        InputStream imageStream = diagramGenerator.generateDiagram(bpmnModel, "png", highLightedActivitis,
                highLightedFlows);
        // 单独返回流程图，不高亮显示
        // InputStream imageStream = diagramGenerator.generatePngDiagram(bpmnModel);
        // 输出资源内容到相应对象
        byte[] b = new byte[1024];
        int len;
        while ((len = imageStream.read(b, 0, 1024)) != -1) {
            response.getOutputStream().write(b, 0, len);
        }
    }

    /**
     * 获取需要高亮的线
     * 
     * @param processDefinitionEntity
     * @param historicActivityInstances
     * @return
     */
    private List<String> getHighLightedFlows(ProcessDefinitionEntity processDefinitionEntity,
        List<HistoricActivityInstance> historicActivityInstances) {
        List<String> highFlows = new ArrayList<String>();// 用以保存高亮的线flowId
        for (int i = 0; i < historicActivityInstances.size() - 1; i++) {// 对历史流程节点进行遍历
            ActivityImpl activityImpl = processDefinitionEntity
                    .findActivity(historicActivityInstances.get(i).getActivityId());// 得到节点定义的详细信息
            List<ActivityImpl> sameStartTimeNodes = new ArrayList<ActivityImpl>();// 用以保存后需开始时间相同的节点
            ActivityImpl sameActivityImpl1 = processDefinitionEntity
                    .findActivity(historicActivityInstances.get(i + 1).getActivityId());
            // 将后面第一个节点放在时间相同节点的集合里
            sameStartTimeNodes.add(sameActivityImpl1);
            for (int j = i + 1; j < historicActivityInstances.size() - 1; j++) {
                HistoricActivityInstance activityImpl1 = historicActivityInstances.get(j);// 后续第一个节点
                HistoricActivityInstance activityImpl2 = historicActivityInstances.get(j + 1);// 后续第二个节点
                if (activityImpl1.getStartTime().equals(activityImpl2.getStartTime())) {
                    // 如果第一个节点和第二个节点开始时间相同保存
                    ActivityImpl sameActivityImpl2 = processDefinitionEntity
                            .findActivity(activityImpl2.getActivityId());
                    sameStartTimeNodes.add(sameActivityImpl2);
                } else {
                    // 有不相同跳出循环
                    break;
                }
            }
            List<PvmTransition> pvmTransitions = activityImpl.getOutgoingTransitions();// 取出节点的所有出去的线
            for (PvmTransition pvmTransition : pvmTransitions) {
                // 对所有的线进行遍历
                ActivityImpl pvmActivityImpl = (ActivityImpl) pvmTransition.getDestination();
                // 如果取出的线的目标节点存在时间相同的节点里，保存该线的id，进行高亮显示
                if (sameStartTimeNodes.contains(pvmActivityImpl)) {
                    highFlows.add(pvmTransition.getId());
                }
            }
        }
        return highFlows;
    }

}
