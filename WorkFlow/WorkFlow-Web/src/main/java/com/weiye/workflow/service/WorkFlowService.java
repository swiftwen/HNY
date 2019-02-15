package com.weiye.workflow.service;

import java.util.Map;

import org.activiti.engine.ManagementService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.Job;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weiye.config.ActivitiConfig;

@Service
public class WorkFlowService  {

    @Autowired
    private ActivitiConfig activitiConfig;
	
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 流程启动
     * 
     * @param processDefinitionKey 流程定义key
     * @param userId 申请用户ID
     * @param businessKey 业务主键
     * @param variables 流程参数
     * @param tenantId 租户设计
     * @return 流程实例ID
     */
    public String startWorkFlowProcess(String processDefinitionKey, String userId, String businessKey,
        Map<String, Object> variables, String tenantId) {
        ProcessInstance processInstance = null;
        // 设置申请ID到历史流程实例表ACT_HI_PROCINST
        activitiConfig.identityService().setAuthenticatedUserId(userId);
        if (StringUtils.isNotBlank(tenantId)) {
            processInstance = activitiConfig.runtimeService().startProcessInstanceByKeyAndTenantId(processDefinitionKey,
                    businessKey, variables, tenantId);
        } else {
            processInstance = activitiConfig.runtimeService().startProcessInstanceByKey(processDefinitionKey,
                    businessKey, variables);
        }
        return processInstance.getId();
    }
    
    /**
     * 领取任务
     */
    public void claimTask(String taskId, String userId) {
        activitiConfig.taskService().claim(taskId, userId);
    }

    /**
     * 退回
     * @param taskId
     * @param userId
     */
    public void unclaimTask(String taskId) {
        // 任务退回清除认领时间及认领人
        activitiConfig.taskService().unclaim(taskId);
    }

    /**
     * 审批完成任务
     * 
     * @param taskId 任务ID
     * @param variables 参数
     * @param message 批注内容
     */
    public void completeTask(String taskId, Map<String, Object> variables, String message) {
        TaskService taskService = activitiConfig.taskService();
        if (StringUtils.isNotBlank(message)) {
            // 添加批注内容,act_hi_comment表里
            Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
            taskService.addComment(taskId, task.getProcessInstanceId(), message);
        }
        if (variables != null) {
            taskService.complete(taskId, variables);
        } else {
            taskService.complete(taskId);
        }
    }

    /**
     * 执行异常案件
     * 
     * @param processInstanceId
     */
    public void resolveException(String processInstanceId) {
        ManagementService managementService = activitiConfig.managementService();
        Job job = managementService.createJobQuery().withException()
                .processInstanceId(processInstanceId).singleResult();
        if (job != null) {
            try {
                managementService.executeJob(job.getId());
            } catch (Exception e) {
                throw new RuntimeException("执行异常失败，请人工排查！");
            }
        }
    }
}
