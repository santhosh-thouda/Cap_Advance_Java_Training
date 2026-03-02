package com.capgemini.banking;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.banking.config.BankingAppConfig;
import com.capgemini.banking.service.AuditService;
import com.capgemini.banking.service.LoanService;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Banking Loan Approval System ===\n");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BankingAppConfig.class);

        LoanService loanService = context.getBean(LoanService.class);

        // Manually inject setter dependency
        AuditService auditService = context.getBean(AuditService.class);
        loanService.setAuditService(auditService);

        loanService.approveLoan(50000);
        loanService.approveLoan(100000);

        context.close();

        System.out.println("\n=== Application Closed ===");
    }
}