package com.example.workflow;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/process")
public class ProcessController {
    private final ProcessService processService;

    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @PostMapping("/start")
    public String startProcess(@RequestParam String employeeId) {
        return processService.startProcess(employeeId);
    }

    @PostMapping("/task/{taskId}/complete")
    public void completeTask(@PathVariable String taskId, @RequestBody Map<String, Object> variables) {
        processService.completeTask(taskId, variables);
    }
}
