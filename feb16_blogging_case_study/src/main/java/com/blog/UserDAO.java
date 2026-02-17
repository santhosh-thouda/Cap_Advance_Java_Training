package com.blog;

import javax.persistence.*;
import java.util.List;

public class UserDAO {

    public void saveUser(User user) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(user);
        tx.commit();
        em.close();
    }

    public User findUser(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    public List<Post> getPostsByUser(Long userId) {
        EntityManager em = JPAUtil.getEntityManager();
        Query q = em.createQuery(
                "SELECT u.posts FROM User u WHERE u.id = :id");
        q.setParameter("id", userId);
        List<Post> posts = q.getResultList();
        em.close();
        return posts;
    }

    public List<Comment> getCommentsByUser(Long userId) {
        EntityManager em = JPAUtil.getEntityManager();
        Query q = em.createQuery(
                "SELECT u.comments FROM User u WHERE u.id = :id");
        q.setParameter("id", userId);
        List<Comment> comments = q.getResultList();
        em.close();
        return comments;
    }
}
