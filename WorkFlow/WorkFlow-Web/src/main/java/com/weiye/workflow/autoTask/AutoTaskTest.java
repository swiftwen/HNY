package com.weiye.workflow.autoTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AutoTaskTest extends AbstractDelegateTask {

    private Logger logger = LoggerFactory.getLogger(getClass());




    @Override
    public void execute(WfpDelegateExecution execute) {
        String teString = "111";
        logger.info("测试执行的" + teString);
        // if ("1".equals("1")) {
        // throw new RuntimeException("测试报异常");
        // }
        execute.setVariable("rtfState", "reject");
        execute.setVariable("assignee", "weiyeAuto");

    }


    // @Override
    // public void execute(DelegateExecution execution) {
    // String teString = "111";
    // logger.info("测试执行的" + teString);
    // execution.setVariable("rtfState", "reject");
    // execution.setVariable("assignee", "weiyeAuto");
    // }

}
