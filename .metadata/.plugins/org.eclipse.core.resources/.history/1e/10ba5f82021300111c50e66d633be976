package com.fintech.dao;

import com.fintech.entity.Card;
import com.fintech.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CardDAO {

    public void save(Card card) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(card);
        tx.commit();

        em.close();
    }

    public Card findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Card card = em.find(Card.class, id);
        em.close();
        return card;
    }
}