package com.capgemini.banking.service;

import com.capgemini.banking.validator.LoanValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LoanService {

    private final LoanValidator loanValidator;
    private AuditService auditService;

    // Constructor Injection with Qualifier
    public LoanService(@Qualifier("incomeValidator") LoanValidator loanValidator) {
        this.loanValidator = loanValidator;
        System.out.println("LoanService Constructor Called");
    }

    // Setter Injection
    public void setAuditService(AuditService auditService) {
        this.auditService = auditService;
    }

    public void approveLoan(double amount) {
        loanValidator.validateLoan(amount);
        auditService.logAudit("Loan Approved for amount: " + amount);
        System.out.println("Loan Processing Completed\n");
    }
}