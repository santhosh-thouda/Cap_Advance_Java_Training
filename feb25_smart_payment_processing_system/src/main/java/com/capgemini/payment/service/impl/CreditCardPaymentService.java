package com.capgemini.payment.service.impl;

import com.capgemini.payment.model.PaymentRequest;
import com.capgemini.payment.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class CreditCardPaymentService implements PaymentService {

    @Override
    public void processPayment(PaymentRequest request) {
        System.out.println("Processing Credit Card payment of ₹"
                + request.getAmount());
    }

    @Override
    public String getPaymentType() {
        return "creditCard";
    }
}