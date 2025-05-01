package com.example.workflow;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class ProcessService {
    private final RuntimeService runtimeService;
    private final TaskService taskService;

    public ProcessService(RuntimeService runtimeService, TaskService taskService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
    }

    public String startProcess(String employeeId) {
        return runtimeService.createProcessInstanceBuilder()
                .processDefinitionKey("vacationRequest")
                .variable("initiator", employeeId)
                .start()
                .getId();
    }

    public void completeTask(String taskId, Map<String, Object> variables) {
        taskService.complete(taskId, variables);
    }
}
