package com.university;

import javax.persistence.*;

public class InstructorDAO {

    public void saveInstructor(Instructor instructor) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(instructor);
        tx.commit();
        em.close();
    }

    public Instructor findInstructor(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Instructor i = em.find(Instructor.class, id);
        em.close();
        return i;
    }

    public void updateInstructor(Instructor instructor) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(instructor);
        tx.commit();
        em.close();
    }
}
