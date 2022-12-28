package com.merchen.activiti_demo.activitidemo.deployController;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author MrChen
 * @create 2022-12-27 22:02
 */
@RestController
public class ActivitiController{
    @Autowired
    private RepositoryService repositoryService;

    /**
     * 前端上传流程部署到db中
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/load/process")
    public String loadProcess(MultipartFile file) throws IOException {

        //获取上传文件名字
        String originalFilename = file.getOriginalFilename();
        Deployment deployment = repositoryService
                .createDeployment()
                .name("测试工作流")
                .addBytes(originalFilename, file.getBytes())
//                .tenantId("")  租户ID
                .deploy();
        //打印部署结果
        System.out.println(deployment);
        return "success";
    }

    /**
     * 查询流程定义对象列表
     */
    @GetMapping("/get/process/{processKey}")
    public ProcessDefinition getProcessList(@PathVariable("processKey")String key){
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery().processDefinitionKey(key);
        ProcessDefinition processDefinition = query.latestVersion().singleResult();
        return processDefinition;
    }

    /**
     * 开启或者挂起流程功能
     */
    @PutMapping("/suspend/process/{process_id}/{process_key}")
    public String suspendProcess(@PathVariable("process_id")String id,
                                 @PathVariable("process_key")String key){
        ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery()
                .processDefinitionTenantId(id)
                .processDefinitionKey(key)
                .singleResult();
        if(processDefinition.isSuspended()){
            repositoryService.activateProcessDefinitionById(id);
        }else{
            repositoryService.suspendProcessDefinitionById(id);
        }
        return "ok";
    }


    /**
     * 开启流程
     */


}
