package com.weiye.workflow.autoTask;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AutoTaskTest implements JavaDelegate {

    private Logger logger = LoggerFactory.getLogger(getClass());



    @Override
    public void execute(DelegateExecution execution) {
        String teString = "111";
        logger.info("测试执行的" + teString);
        execution.setVariable("rtfState", "reject");
        execution.setVariable("assignee", "weiyeAuto");
    }


}
