package com.capgemini.banking.validator;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CreditScoreValidator implements LoanValidator {

    public CreditScoreValidator() {
        System.out.println("CreditScoreValidator Created");
    }

    @Override
    public void validateLoan(double amount) {
        System.out.println("Validating loan using Credit Score for amount: " + amount);
    }
}