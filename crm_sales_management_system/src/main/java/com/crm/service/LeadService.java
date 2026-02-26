package com.crm.service;

import com.crm.entity.*;
import javax.persistence.*;

public class LeadService {

    private EntityManager em;

    public LeadService(EntityManager em) {
        this.em = em;
    }

    public void createLead(String name, String source, String contactInfo) {

        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            Lead lead = new Lead();
            lead.setName(name);
            lead.setSource(source);
            lead.setContactInfo(contactInfo);

            em.persist(lead);

            et.commit();
            System.out.println("Lead Created Successfully");

        } catch (Exception e) {
            et.rollback();
        }
    }

    public void assignLeadToEmployee(Long leadId, Long employeeId) {

        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            Lead lead = em.find(Lead.class, leadId);
            SalesEmployee employee = em.find(SalesEmployee.class, employeeId);

            if (lead != null && employee != null) {
                lead.setEmployee(employee);
            }

            et.commit();
            System.out.println("Lead Assigned Successfully");

        } catch (Exception e) {
            et.rollback();
        }
    }

    public void convertLeadToCustomer(Long leadId) {

        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            Lead lead = em.find(Lead.class, leadId);

            if (lead != null) {
                Customer customer = new Customer();
                customer.setName(lead.getName());
                customer.setEmail(lead.getContactInfo());
                customer.setPhone("Converted");

                em.persist(customer);
                em.remove(lead);
            }

            et.commit();
            System.out.println("Lead Converted to Customer");

        } catch (Exception e) {
            et.rollback();
        }
    }
}