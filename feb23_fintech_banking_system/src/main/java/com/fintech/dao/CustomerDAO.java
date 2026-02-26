package com.fintech.dao;

import com.fintech.entity.Customer;
import com.fintech.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class CustomerDAO {

    public void save(Customer customer) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(customer);
        tx.commit();

        em.close();
    }

    public Customer findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Customer customer = em.find(Customer.class, id);
        em.close();
        return customer;
    }

    public List<Customer> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Customer> list =
                em.createQuery("FROM Customer", Customer.class)
                        .getResultList();
        em.close();
        return list;
    }

    public void delete(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Customer customer = em.find(Customer.class, id);
        if (customer != null)
            em.remove(customer);
        tx.commit();

        em.close();
    }
}