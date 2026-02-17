package com.blog;

import javax.persistence.*;

public class CommentDAO {

    public void saveComment(Comment comment) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(comment);
        tx.commit();
        em.close();
    }
}
