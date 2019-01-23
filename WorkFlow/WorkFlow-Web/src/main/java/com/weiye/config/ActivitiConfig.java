package com.weiye.config;

import javax.sql.DataSource;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;


/**
 * 使用Java类完成配置文件
 * @author zc 2018-06-04
 */
@Configuration
public class ActivitiConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ResourcePatternResolver resourceLoader;

    /**
     * 初始化配置，将创建28张表
     * 
     * @return
     */
    @Bean
    public StandaloneProcessEngineConfiguration processEngineConfiguration() {
        StandaloneProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration();
        configuration.setDataSource(dataSource);
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // configuration.setAsyncExecutorActivate(true);
        // configuration.setAsyncExecutorAsyncJobLockTimeInMillis(0);
        // configuration.setAsyncExecutorMaxPoolSize(10);// 线程池最大数量
        // configuration.setAsyncExecutorCorePoolSize(3);
        // configuration.setAsyncExecutorThreadPoolQueueSize(3);
        configuration.setJobExecutorActivate(true);
        configuration.setProcessDefinitionCacheLimit(10);// 部署缓存配置，此属性的最佳值取决于所存储的流程定义的总量以及所有运行时流程实例在运行时实际使用的流程定义的数量。
        // DefaultJobExecutor jobExecutor = new DefaultJobExecutor();
        // jobExecutor.setQueueSize(3);
        // jobExecutor.setCorePoolSize(3);
        // jobExecutor.setMaxPoolSize(1);//多个线程池造成事务提交失败
        // jobExecutor.setLockTimeInMillis(0);
        // configuration.setJobExecutor(jobExecutor);// activiti6版本的异步自动节点在job里面没记录
        return configuration;
    }

    @Bean
    public ProcessEngine processEngine() {
        return processEngineConfiguration().buildProcessEngine();
    }

    @Bean
    public RepositoryService repositoryService() {
        return processEngine().getRepositoryService();
    }

    @Bean
    public RuntimeService runtimeService() {
        return processEngine().getRuntimeService();
    }

    @Bean
    public TaskService taskService() {
        return processEngine().getTaskService();
    }

    @Bean
    public IdentityService identityService() {
        return processEngine().getIdentityService();
    }

    @Bean
    public ManagementService managementService() {
        return processEngine().getManagementService();
    }

    /**
     * 部署流程
     * 
     * @throws IOException
     */
    // @PostConstruct
    // public void initProcess() throws IOException {
    // DeploymentBuilder deploymentBuilder= repositoryService().createDeployment();
    //// Resource resource = resourceLoader.getResource("classpath:/processes/EceProvinceProcess.bpmn");
    //// deploymentBuilder .enableDuplicateFiltering().addInputStream(resource.getFilename(),
    // resource.getInputStream()).name("deploymentTest").deploy();
    // deploymentBuilder
    // .enableDuplicateFiltering().addClasspathResource("TestProcess.bpmn").name("deploymentTest").deploy();
//    }
}
