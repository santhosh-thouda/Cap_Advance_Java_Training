package com.crm.service;

import javax.persistence.*;

public class ReportService {

    private EntityManager em;

    public ReportService(EntityManager em) {
        this.em = em;
    }

    public void getEmployeePerformance(Long employeeId) {

        String jpql = "SELECT COUNT(l) FROM Lead l WHERE l.employee.id = :id";

        Long count = em.createQuery(jpql, Long.class)
                       .setParameter("id", employeeId)
                       .getSingleResult();

        System.out.println("Total Leads Assigned: " + count);
    }
}