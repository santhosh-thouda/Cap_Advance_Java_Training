package com.capgemini.food.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.capgemini.food.service.NotificationService;

@Service
@Primary
public class EmailNotification implements NotificationService {

    @Override
    public void sendNotification(String message) {
        System.out.println("EMAIL Notification Sent: " + message);
    }
}