package com.weiye.workflow.autoTask;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public abstract class AbstractDelegateTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        WfpDelegateExecution wfpDelegateExecute = new WfpDelegateExecution(execution);
        execute(wfpDelegateExecute);
    }

    public abstract void execute(WfpDelegateExecution execute);

}
