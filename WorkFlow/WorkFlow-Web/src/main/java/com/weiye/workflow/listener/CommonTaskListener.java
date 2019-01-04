package com.weiye.workflow.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 任务监听器，任务数据生成后执行
 * @author Liweiye
 * @date 2019年1月4日
 */
@Transactional
@Service
public class CommonTaskListener implements TaskListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void notify(DelegateTask delegateTask) {

        String taskKey=delegateTask.getTaskDefinitionKey();//任务节点名称
        String taskName = delegateTask.getName();// 任务节点名称
        String processInstanceId = delegateTask.getExecution().getProcessInstanceId();// 流程实例ID
        logger.info("流程进入人工节点，key[{}],name[{}],流程id[{}]", taskKey, taskName, processInstanceId);
    }

}
