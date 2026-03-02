package com.capgemini.payment.service;

import com.capgemini.payment.model.PaymentRequest;

public interface PaymentService {

    void processPayment(PaymentRequest request);

    String getPaymentType();
}