package com.capgemini.payment.model;

public class PaymentRequest {

    private double amount;
    private String paymentType;

    public PaymentRequest() {}

    public PaymentRequest(double amount, String paymentType) {
        this.amount = amount;
        this.paymentType = paymentType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}