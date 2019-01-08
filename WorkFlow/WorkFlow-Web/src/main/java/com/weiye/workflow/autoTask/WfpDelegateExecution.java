package com.weiye.workflow.autoTask;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.activiti.bpmn.model.ActivitiListener;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.impl.persistence.entity.VariableInstance;

public class WfpDelegateExecution implements DelegateExecution {

    private DelegateExecution delegate;

    public WfpDelegateExecution() {

    }

    public WfpDelegateExecution(DelegateExecution delegate) {
        this.delegate = delegate;
    }
    @Override
    public Map<String, Object> getVariables() {
        return delegate.getVariables();
    }

    @Override
    public Map<String, VariableInstance> getVariableInstances() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Object> getVariables(Collection<String> variableNames) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, VariableInstance> getVariableInstances(Collection<String> variableNames) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Object> getVariables(Collection<String> variableNames, boolean fetchAllVariables) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, VariableInstance> getVariableInstances(Collection<String> variableNames,
        boolean fetchAllVariables) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Object> getVariablesLocal() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, VariableInstance> getVariableInstancesLocal() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Object> getVariablesLocal(Collection<String> variableNames) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, VariableInstance> getVariableInstancesLocal(Collection<String> variableNames) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Object> getVariablesLocal(Collection<String> variableNames, boolean fetchAllVariables) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, VariableInstance> getVariableInstancesLocal(Collection<String> variableNames,
        boolean fetchAllVariables) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getVariable(String variableName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public VariableInstance getVariableInstance(String variableName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getVariable(String variableName, boolean fetchAllVariables) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public VariableInstance getVariableInstance(String variableName, boolean fetchAllVariables) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getVariableLocal(String variableName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public VariableInstance getVariableInstanceLocal(String variableName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getVariableLocal(String variableName, boolean fetchAllVariables) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public VariableInstance getVariableInstanceLocal(String variableName, boolean fetchAllVariables) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T getVariable(String variableName, Class<T> variableClass) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T getVariableLocal(String variableName, Class<T> variableClass) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<String> getVariableNames() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<String> getVariableNamesLocal() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setVariable(String variableName, Object value) {
        delegate.setVariable(variableName, value);

    }

    @Override
    public void setVariable(String variableName, Object value, boolean fetchAllVariables) {
        // TODO Auto-generated method stub

    }

    @Override
    public Object setVariableLocal(String variableName, Object value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object setVariableLocal(String variableName, Object value, boolean fetchAllVariables) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setVariables(Map<String, ? extends Object> variables) {
        delegate.setVariables(variables);
    }

    @Override
    public void setVariablesLocal(Map<String, ? extends Object> variables) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean hasVariables() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasVariablesLocal() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasVariable(String variableName) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasVariableLocal(String variableName) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void removeVariable(String variableName) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeVariableLocal(String variableName) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeVariables(Collection<String> variableNames) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeVariablesLocal(Collection<String> variableNames) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeVariables() {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeVariablesLocal() {
        // TODO Auto-generated method stub

    }

    @Override
    public void setTransientVariable(String variableName, Object variableValue) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setTransientVariableLocal(String variableName, Object variableValue) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setTransientVariables(Map<String, Object> transientVariables) {
        // TODO Auto-generated method stub

    }

    @Override
    public Object getTransientVariable(String variableName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Object> getTransientVariables() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTransientVariablesLocal(Map<String, Object> transientVariables) {
        // TODO Auto-generated method stub

    }

    @Override
    public Object getTransientVariableLocal(String variableName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Object> getTransientVariablesLocal() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeTransientVariableLocal(String variableName) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeTransientVariable(String variableName) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeTransientVariables() {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeTransientVariablesLocal() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getId() {
        return delegate.getId();
    }

    @Override
    public String getProcessInstanceId() {
        return delegate.getProcessInstanceId();
    }

    @Override
    public String getRootProcessInstanceId() {
        return delegate.getRootProcessInstanceId();
    }

    @Override
    public String getEventName() {
        return delegate.getEventName();
    }

    @Override
    public void setEventName(String eventName) {
        delegate.setEventName(eventName);
    }

    @Override
    public String getProcessInstanceBusinessKey() {
        return delegate.getProcessInstanceBusinessKey();
    }

    @Override
    public String getProcessDefinitionId() {
        return delegate.getProcessDefinitionId();
    }

    @Override
    public String getParentId() {
        return delegate.getParentId();
    }

    @Override
    public String getSuperExecutionId() {
        return delegate.getSuperExecutionId();
    }

    @Override
    public String getCurrentActivityId() {
        return delegate.getCurrentActivityId();
    }

    @Override
    public String getTenantId() {
        return delegate.getTenantId();
    }

    @Override
    public FlowElement getCurrentFlowElement() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCurrentFlowElement(FlowElement flowElement) {
        // TODO Auto-generated method stub

    }

    @Override
    public ActivitiListener getCurrentActivitiListener() {
        return delegate.getCurrentActivitiListener();
    }

    @Override
    public void setCurrentActivitiListener(ActivitiListener currentActivitiListener) {
        delegate.setCurrentActivitiListener(currentActivitiListener);
    }

    @Override
    public DelegateExecution getParent() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<? extends DelegateExecution> getExecutions() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setActive(boolean isActive) {
        delegate.setActive(isActive);
    }

    @Override
    public boolean isActive() {

        return delegate.isActive();
    }

    @Override
    public boolean isEnded() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setConcurrent(boolean isConcurrent) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isConcurrent() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isProcessInstanceType() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void inactivate() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isScope() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setScope(boolean isScope) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isMultiInstanceRoot() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setMultiInstanceRoot(boolean isMultiInstanceRoot) {
        // TODO Auto-generated method stub

    }

}
