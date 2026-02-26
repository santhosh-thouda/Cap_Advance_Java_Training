package com.fintech.app;

import com.fintech.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class TestConnection {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        System.out.println("Connected to fintech_db successfully");
        em.close();
        JPAUtil.close();
    }
}