package com.hospital;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PatientDAO {

    public void savePatient(Patient patient) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(patient);
        tx.commit();
        em.close();
    }

    public Patient findPatient(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Patient p = em.find(Patient.class, id);
        em.close();
        return p;
    }

    public void updatePatient(Patient patient) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(patient);
        tx.commit();
        em.close();
    }

    public void deletePatient(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Patient p = em.find(Patient.class, id);
        if (p != null)
            em.remove(p);
        tx.commit();
        em.close();
    }
}
