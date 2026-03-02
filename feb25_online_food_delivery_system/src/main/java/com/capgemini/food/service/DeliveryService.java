package com.capgemini.food.service;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class DeliveryService {

    @PostConstruct
    public void init() {
        System.out.println("Delivery Service Initialized");
    }

    public void deliverOrder(String item) {
        System.out.println("Delivery partner delivering " + item);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Delivery Service Destroyed");
    }
}