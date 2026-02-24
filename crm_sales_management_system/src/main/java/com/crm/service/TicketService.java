package com.crm.service;

import com.crm.entity.*;
import javax.persistence.*;

public class TicketService {

    private EntityManager em;

    public TicketService(EntityManager em) {
        this.em = em;
    }

    public void raiseTicket(Long orderId, String issueDescription) {

        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            Order order = em.find(Order.class, orderId);

            SupportTicket ticket = new SupportTicket();
            ticket.setIssueDescription(issueDescription);
            ticket.setOrder(order);

            em.persist(ticket);

            et.commit();
            System.out.println("Ticket Raised Successfully");

        } catch (Exception e) {
            et.rollback();
        }
    }
}