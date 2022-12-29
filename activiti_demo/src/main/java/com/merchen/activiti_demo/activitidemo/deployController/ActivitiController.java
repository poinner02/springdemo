package com.merchen.activiti_demo.activitidemo.deployController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.merchen.activiti_demo.bean.JsonRootBean;
import lombok.Data;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

/**
 * @author MrChen
 * @create 2022-12-27 22:02
 */
@RestController
public class ActivitiController{

    @Data
    public class LoninUser{
        private String name;
        private String id;
    }
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    /**
     * 1.部署流程
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/deployee/bmpn")
    public String loadProcess(MultipartFile file) throws IOException {

        //获取上传文件名字
        String originalFilename = file.getOriginalFilename();
        Deployment deployment = repositoryService
                .createDeployment()
                .name("请假流程")
                .addBytes(originalFilename, file.getBytes())
//                .tenantId("")  租户ID
                .deploy();
        //打印部署结果
        System.out.println(deployment);
        return "success";
    }
    /**
     * 2.查询流程定义对象列表
     */
    @GetMapping("/get/process/{processKey}")
    public ProcessDefinition getProcessList(@PathVariable("processKey")String key){
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery().processDefinitionKey(key);
        ProcessDefinition processDefinition = query.latestVersion().singleResult();
        return processDefinition;
    }
    /**
     * 3.根据流程定义生成流程实例对象
     *  3.1根据变量控制流程图走向
     *      例如 bpmn分支 condiction  "${lever.days>3}" 走领导审核
     */
    @Data
    class lever {
        int days;
    }
    @PutMapping("/getRealObject")
    public ProcessInstance getRealObjetc(ProcessDefinition processDefinition){

        //指派人assignee
        Map<String, Object> var = new HashMap<>();
        var.put("assignee0","HR初审");
        var.put("assignee1","复审");
        //控制分支流向
        lever lever = new lever();
        lever.setDays(4);
        var.put("lever",lever);
        var.put("assignee2","领导审核");
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId(), var);
        return processInstance;
    }
    /**
     * 4.任务查询
     */
    @GetMapping("/get/task/{processId}")
    public List<Task> getTask(@PathVariable("processId")String id,
                              HttpSession session){
        //模拟登录请求获取user
        LoninUser user = (LoninUser) session.getAttribute("loginUser");
        String userName = user.getName();
        //获取某人taskAssignee在当前processDefinitionId下有多少个任务
        TaskQuery taskQuery = taskService.createTaskQuery();
        List<Task> list = taskQuery.processDefinitionId(id).taskAssignee(userName).list();
        return list;
    }
    /**
     * 5.处理任务
     */
    @PutMapping("/handle/{processId}")
    public String handleTask(@PathVariable("processId")String id,
                             HttpSession session){
        //模拟登录请求获取user
        LoninUser user = (LoninUser) session.getAttribute("loginUser");
        String userName = user.getName();
        //step 4.任务查询
        TaskQuery taskQuery = taskService.createTaskQuery();
        //查询某人的流程任务
        List<Task> list = taskQuery.processDefinitionId(id).taskAssignee(userName).list();
        for (Task task : list) {
            //完成任务
            taskService.complete(task.getId());
        }
        return "ok";
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



}
