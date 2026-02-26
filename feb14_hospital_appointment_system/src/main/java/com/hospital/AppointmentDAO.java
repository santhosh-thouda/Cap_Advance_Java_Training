package com.hospital;

import javax.persistence.*;
import java.util.List;

public class AppointmentDAO {

    public void saveAppointment(Appointment appointment) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(appointment);
        tx.commit();
        em.close();
    }

    public void updateFee(int id, double newFee) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Appointment a = em.find(Appointment.class, id);
        if (a != null)
            a.setFee(newFee);
        tx.commit();
        em.close();
    }

    public List<Appointment> findAppointmentByDoctor(int doctorId) {
        EntityManager em = JPAUtil.getEntityManager(); 
        Query q = em.createQuery(
            "SELECT d.appointments FROM Doctor d WHERE d.id = :id");
        q.setParameter("id", doctorId);
        List<Appointment> list = q.getResultList();
        em.close();
        return list;
    }
}
