package com.capgemini.payment.service;

import com.capgemini.payment.exception.InvalidPaymentException;
import com.capgemini.payment.model.PaymentRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentProcessor {

    private final List<PaymentService> paymentServices;

    public PaymentProcessor(List<PaymentService> paymentServices) {
        this.paymentServices = paymentServices;
    }

    public void processPayment(PaymentRequest request) {

        if (request.getAmount() <= 0) {
            throw new InvalidPaymentException("Amount must be greater than 0");
        }

        for (PaymentService service : paymentServices) {
            if (service.getPaymentType()
                    .equalsIgnoreCase(request.getPaymentType())) {

                service.processPayment(request);
                return;
            }
        }

        throw new InvalidPaymentException("Invalid payment type: "
                + request.getPaymentType());
    }
}