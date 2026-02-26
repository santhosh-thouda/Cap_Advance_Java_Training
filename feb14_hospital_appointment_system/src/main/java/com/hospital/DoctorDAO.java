package com.hospital;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DoctorDAO {

    public void saveDoctor(Doctor doctor) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(doctor);
        tx.commit();
        em.close();
    }

    public Doctor findDoctor(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Doctor d = em.find(Doctor.class, id);
        em.close();
        return d;
    }
}
