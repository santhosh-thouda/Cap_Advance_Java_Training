package com.ecommerce;

import javax.persistence.*;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public void saveOrder(PurchaseOrder o) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(o);
        tx.commit();
        em.close();
    }

    @Override
    public PurchaseOrder findOrder(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        PurchaseOrder order = em.find(PurchaseOrder.class, id);
        em.close();
        return order;
    }

    @Override
    public List<PurchaseOrder> findOrdersByUser(Long userId) {
        EntityManager em = JPAUtil.getEntityManager();
        Query q = em.createQuery(
                "SELECT u.orders FROM User u WHERE u.id = :id");
        q.setParameter("id", userId);
        List<PurchaseOrder> list = q.getResultList();
        em.close();
        return list;
    }
}
