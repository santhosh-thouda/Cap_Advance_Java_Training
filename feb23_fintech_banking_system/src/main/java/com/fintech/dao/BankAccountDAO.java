package com.fintech.dao;

import com.fintech.entity.BankAccount;
import com.fintech.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class BankAccountDAO {

    public void save(BankAccount account) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(account);
        tx.commit();

        em.close();
    }

    public BankAccount findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        BankAccount account = em.find(BankAccount.class, id);
        em.close();
        return account;
    }

    public List<BankAccount> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<BankAccount> list =
                em.createQuery("FROM BankAccount", BankAccount.class)
                        .getResultList();
        em.close();
        return list;
    }

    public void update(BankAccount account) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(account);
        tx.commit();

        em.close();
    }
}