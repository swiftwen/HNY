package com.weiye.workflow.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.task.Task;
import org.apache.commons.io.FileUtils;
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
}
