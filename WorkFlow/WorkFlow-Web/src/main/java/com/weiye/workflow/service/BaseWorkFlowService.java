package com.weiye.workflow.service;

import javax.annotation.PostConstruct;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class BaseWorkFlowService {
	@Autowired
	private ProcessEngine processEngine;
	

	@Autowired
	private TaskService taskService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private IdentityService identityService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private ManagementService managementService;
	
	public ManagementService getManagementService() {
		return managementService;
	}

	public void setManagementService(ManagementService managementService) {
		this.managementService = managementService;
	}

	private FormService formService;

	public ProcessEngine getProcessEngine() {
		return processEngine;
	}

	public void setProcessEngine(ProcessEngine processEngine) {
		this.processEngine = processEngine;
	}

	public TaskService getTaskService() {
		return taskService;
	}

	public RuntimeService getRuntimeService() {
		return runtimeService;
	}

	public HistoryService getHistoryService() {
		return historyService;
	}

	public IdentityService getIdentityService() {
		return identityService;
	}

	public RepositoryService getRepositoryService() {
		return repositoryService;
	}

	@PostConstruct
	public void init() {
		taskService = processEngine.getTaskService();
		runtimeService = processEngine.getRuntimeService();
		historyService = processEngine.getHistoryService();
		identityService = processEngine.getIdentityService();
		repositoryService = processEngine.getRepositoryService();
	    formService = processEngine.getFormService();
	    managementService = processEngine.getManagementService();
	}

	public FormService getFormService() {
		return formService;
	}
}
