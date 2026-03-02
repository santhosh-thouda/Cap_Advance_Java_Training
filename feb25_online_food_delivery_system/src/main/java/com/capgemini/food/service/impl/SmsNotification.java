package com.capgemini.food.service.impl;

import org.springframework.stereotype.Service;

import com.capgemini.food.service.NotificationService;

@Service
public class SmsNotification implements NotificationService {

    @Override
    public void sendNotification(String message) {
        System.out.println("SMS Notification Sent: " + message);
    }
}