package com.university;

import javax.persistence.*;

public class EnrollmentDAO {

    public void saveEnrollment(Enrollment enrollment) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(enrollment);
        tx.commit();
        em.close();
    }

    public void updateGrade(int id, String grade) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Enrollment e = em.find(Enrollment.class, id);
        if (e != null)
            e.setGrade(grade);
        tx.commit();
        em.close();
    }
}
