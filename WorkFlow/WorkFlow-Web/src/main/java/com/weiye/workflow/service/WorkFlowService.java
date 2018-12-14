package com.weiye.workflow.service;

import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weiye.config.ActivitiConfig;

@Service
public class WorkFlowService  {

    @Autowired
    private ActivitiConfig activitiConfig;
	

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
}
