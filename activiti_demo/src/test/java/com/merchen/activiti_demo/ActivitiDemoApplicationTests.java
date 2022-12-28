package com.merchen.activiti_demo;


import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiDemoApplicationTests {


    @Autowired
    RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    /**
     * 工作流步骤
     */
    @Test
    public void totalworkflow(){
        String id = "";
        //查询流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().singleResult();
        //开启流程功能
        if(processDefinition.isSuspended()){
            repositoryService.activateProcessDefinitionById(id);
        }else{
            repositoryService.suspendProcessDefinitionById(id);
        }
        //开始流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(id);
        Task task = taskService.createTaskQuery().processDefinitionId(processInstance.getId()).singleResult();
        taskService.complete(task.getId());

    }
    //=======================================================

    /**
     * 构建activiti对象且初始化
     */
    @Test
    public void initActiviti() {
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(defaultProcessEngine);

    }

    /**
     * 查询流程定义对象
     */
    @Test
    public void findAll(){
        //1.获取流程定义查询对象query
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
        //2.添加查询条件
//        query.processDefinitionTenantIdLike("") //租户id
        //3.查询
        List<ProcessDefinition> list = query.latestVersion().list();
        System.out.println(list);
    }
    /**
     * 流程挂起和激活
     */
    @Test
    public void processSuspend(){
        //挂起
//        repositoryService.suspendProcessDefinitionById("sale-flow:1:2503");
        //激活流程
        repositoryService.activateProcessDefinitionById("sale-flow:1:2503");
    }

    /**
     * 开启流程
     */
    @Test
    public void beginProcess(){
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionTenantId("").latestVersion().singleResult();
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId());
        Task task = taskService.createTaskQuery().processDefinitionId(processInstance.getId()).singleResult();
        taskService.complete(task.getId());
    }
    
}
