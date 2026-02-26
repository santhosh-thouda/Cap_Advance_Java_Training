package com.fintech.dao;

import com.fintech.entity.Transaction;
import com.fintech.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class TransactionDAO {

    public void save(Transaction transaction) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(transaction);
        tx.commit();

        em.close();
    }

    public List<Transaction> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Transaction> list =
                em.createQuery("FROM Transaction", Transaction.class)
                        .getResultList();
        em.close();
        return list;
    }
}