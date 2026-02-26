package com.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDAOImpl implements UserDAO {

    @Override
    public void saveUser(User u) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(u);
        tx.commit();
        em.close();
    }

    @Override
    public User findUser(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
        tx.commit();
        em.close();
    }

    @Override
    public void updateUser(User u) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(u);
        tx.commit();
        em.close();
    }
}
