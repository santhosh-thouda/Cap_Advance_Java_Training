package com.capgemini.banking.validator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class IncomeValidator implements LoanValidator {

    public IncomeValidator() {
        System.out.println("IncomeValidator Created");
    }

    @Override
    public void validateLoan(double amount) {
        System.out.println("Validating loan using Income for amount: " + amount);
    }
}