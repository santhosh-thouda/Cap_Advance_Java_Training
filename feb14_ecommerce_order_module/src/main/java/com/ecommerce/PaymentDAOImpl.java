package com.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public void savePayment(Payment p) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(p);
        tx.commit();
        em.close();
    }

    @Override
    public Payment findPayment(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Payment payment = em.find(Payment.class, id);
        em.close();
        return payment;
    }
}
