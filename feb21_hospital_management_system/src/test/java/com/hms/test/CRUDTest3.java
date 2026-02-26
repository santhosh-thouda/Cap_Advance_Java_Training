package com.hms.test;

import com.hms.entity.*;
import com.hms.util.JPAUtil;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CRUDTest3 {

    private EntityManager em;
    private EntityTransaction tx;

    @BeforeEach
    void setUp() {
        em = JPAUtil.getEntityManager();
        tx = em.getTransaction();
        System.out.println("\n=== TEST 3: Uni 1:N ===\n");
    }

    @AfterEach
    void tearDown() {
        if (tx.isActive()) tx.rollback();
        if (em.isOpen()) em.close();
    }

    @Test
    void testDoctorAppointments() {

        tx.begin();

        Doctor doctor = new Doctor();
        doctor.setName("Dr Brown");

        Appointment a1 = new Appointment();
        a1.setAppointDate(LocalDateTime.now());
        a1.setStatus("SCHEDULED");

        doctor.getAppointments().add(a1);

        em.persist(doctor);
        Long id = doctor.getId();
        tx.commit();

        em.clear();
        Doctor loaded = em.find(Doctor.class,id);

        assertEquals(1,
                loaded.getAppointments().size());
    }
}