package com.hms.test;

import com.hms.entity.*;
import com.hms.util.JPAUtil;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CRUDTest4 {

    private EntityManager em;
    private EntityTransaction tx;

    @BeforeEach
    void setUp() {
        em = JPAUtil.getEntityManager();
        tx = em.getTransaction();
        System.out.println("\n=== TEST 4: Uni 1:1 Optional ===\n");
    }

    @AfterEach
    void tearDown() {
        if (tx.isActive()) tx.rollback();
        if (em.isOpen()) em.close();
    }

    @Test
    void testAppointmentPrescription() {

        tx.begin();
        Prescription p = new Prescription();
        p.setMedicines("Paracetamol");
        p.setIssuedDate(LocalDate.now());

        Appointment a = new Appointment();
        a.setAppointDate(LocalDateTime.now());
        a.setPrescription(p);

        em.persist(a);
        Long id = a.getId();
        tx.commit();

        em.clear();
        assertNotNull(em.find(Appointment.class,id).getPrescription());
    }

    @Test
    void testOptionalNull() {

        tx.begin();
        Appointment a = new Appointment();
        a.setAppointDate(LocalDateTime.now());

        em.persist(a);
        Long id = a.getId();
        tx.commit();

        em.clear();
        assertNull(em.find(Appointment.class,id).getPrescription());
    }
}