package com.blog;

import javax.persistence.*;
import java.util.List;

public class PostDAO {

    public void savePost(Post post) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(post);
        tx.commit();
        em.close();
    }

    public Post findPost(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Post post = em.find(Post.class, id);
        em.close();
        return post;
    }

    public void updatePost(Post post) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(post);
        tx.commit();
        em.close();
    }

    public void deletePost(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Post post = em.find(Post.class, id);
        if (post != null)
            em.remove(post);
        tx.commit();
        em.close();
    }

    public List<Comment> getCommentsByPost(Long postId) {
        EntityManager em = JPAUtil.getEntityManager();
        Query q = em.createQuery(
                "SELECT p.comments FROM Post p WHERE p.id = :id");
        q.setParameter("id", postId);
        List<Comment> comments = q.getResultList();
        em.close();
        return comments;
    }
}
