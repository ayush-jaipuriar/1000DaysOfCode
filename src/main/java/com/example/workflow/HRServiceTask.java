package com.example.workflow;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("hrServiceTask")
public class HRServiceTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("Storing vacation request in HR system:");
        System.out.println("Employee: " + execution.getVariable("initiator"));
        System.out.println("Dates: " + execution.getVariable("startDate") + " - " + execution.getVariable("endDate"));
    }
}
