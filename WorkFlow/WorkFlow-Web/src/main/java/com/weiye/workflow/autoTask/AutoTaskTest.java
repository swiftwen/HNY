package com.weiye.workflow.autoTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(value = "autoTaskTest")
public class AutoTaskTest extends AbstractDelegateTask {

    private Logger logger = LoggerFactory.getLogger(getClass());




    @Override
    public void execute(WfpDelegateExecution execute) {
        String teString = "111";
        logger.info("测试执行的" + teString);
        execute.setVariable("rtfState", "reject");
        execute.setVariable("assignee", "weiyeAuto");

    }


    // @Override
    // public void execute(DelegateExecution execution) {
    // String teString = "111";
    // logger.info("测试执行的" + teString);
    // if ("1".equals("1")) {
    // throw new ProcessException("测试报异常" + execution.getProcessInstanceId()
    // + org.apache.http.client.utils.DateUtils.formatDate(new Date()));
    // }
    // execution.setVariable("rtfState", "reject");
    // execution.setVariable("assignee", "weiyeAuto");
    // }

}
