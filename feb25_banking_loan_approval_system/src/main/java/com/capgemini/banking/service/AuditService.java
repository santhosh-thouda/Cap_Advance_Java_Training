package com.capgemini.banking.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class AuditService {

    public AuditService() {
        System.out.println("AuditService Constructor Called");
    }

    @PostConstruct
    public void init() {
        System.out.println("AuditService Initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("AuditService Destroyed");
    }

    public void logAudit(String message) {
        System.out.println("AUDIT LOG: " + message);
    }
}