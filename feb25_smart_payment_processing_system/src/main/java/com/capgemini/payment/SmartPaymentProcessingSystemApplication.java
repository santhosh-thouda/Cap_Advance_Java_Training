package com.capgemini.payment;

import com.capgemini.payment.config.AppConfig;
import com.capgemini.payment.model.PaymentRequest;
import com.capgemini.payment.service.PaymentProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SmartPaymentProcessingSystemApplication {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" Smart Payment Processing System");
        System.out.println("========================================");

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        PaymentProcessor processor = context.getBean(PaymentProcessor.class);

        PaymentRequest r1 = new PaymentRequest(828.50, "creditCard");
        PaymentRequest r2 = new PaymentRequest(340.75, "debitCard");
        PaymentRequest r3 = new PaymentRequest(98.00, "upi");

        processor.processPayment(r1);
        processor.processPayment(r2);
        processor.processPayment(r3);

        ((AnnotationConfigApplicationContext) context).close();
    }
}