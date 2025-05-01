package com.example.workflow;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("notificationDelegate")
public class NotificationDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        String status = execution.getCurrentFlowElement().getId().equals("notifyApproval") 
                        ? "APPROVED" : "REJECTED";
        
        System.out.println("\n=== NOTIFICATION ===");
        System.out.println("To: " + execution.getVariable("initiator"));
        System.out.println("Your vacation request has been " + status);
        System.out.println("Manager comments: " + execution.getVariable("comments"));
        System.out.println("===================\n");
    }
}
