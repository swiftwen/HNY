package com.weiye.workflow.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * 全局监听器，开始与结束事件监听,亦可监听非人工节点，如自动节点，等待节点
 * 
 * @author Liweiye
 * @date 2019年1月23日
 */
@Service
public class MyEventListener implements ExecutionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Logger logger = LoggerFactory.getLogger(getClass());

    // @Override
    // public void notify(DelegateTask delegateTask) {
    // String eventName = delegateTask.getEventName();
    // if ("create".endsWith(eventName)) {
    // logger.info("create=========");
    // } else if ("assignment".endsWith(eventName)) {
    // logger.info("assignment========");
    // } else if ("complete".endsWith(eventName)) {
    // logger.info("complete===========");
    // } else if ("delete".endsWith(eventName)) {
    // logger.info("delete=============");
    // } else if ("all".endsWith(eventName)) {
    // logger.info("all1=============");
    // }
    // }

    @Override
    public void notify(DelegateExecution execution) throws Exception {

        String eventName = execution.getEventName();
        // start
        if ("start".equals(eventName)) {
            logger.info("start=========");
        } else if ("end".equals(eventName)) {
            logger.info("end=========");
        } else if ("take".equals(eventName)) {
            logger.info("take=========");
        } else if ("all".endsWith(eventName)) {
            logger.info("all2=============");
        }
    }
    //
    // @Override
    // public void onEvent(ActivitiEvent event) {
    // switch (event.getType()) {
    //
    // case JOB_EXECUTION_SUCCESS:
    // logger.info("A job well done!");
    // break;
    //
    // case JOB_EXECUTION_FAILURE:
    // logger.info("A job has failed...");
    // break;
    //
    // default:
    // logger.info("Event received: " + event.getType());
    // }
    // }
    //
    // @Override
    // public boolean isFailOnException() {
    // // The logic in the onEvent method of this listener is not critical, exceptions
    // // can be ignored if logging fails...
    // logger.info("Event fail: ");
    //
    // return false;
    // }

}
