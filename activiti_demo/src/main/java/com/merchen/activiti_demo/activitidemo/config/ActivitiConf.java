package com.merchen.activiti_demo.activitidemo.config;

import org.activiti.engine.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MrChen
 * @create 2022-12-28 19:14
 */
@Configuration
public class ActivitiConf {

    @Bean
    RepositoryService getRepositoryService(){
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();
        return repositoryService;
    }

    @Bean
    RuntimeService runtimeService(){
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = defaultProcessEngine.getRuntimeService();
        return runtimeService;
    }
    @Bean
    TaskService taskService(){
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = defaultProcessEngine.getTaskService();
        return taskService;
    }
}
