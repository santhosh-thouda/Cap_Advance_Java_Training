package com.hms.test;

import com.hms.entity.*;
import com.hms.util.JPAUtil;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CRUDTest5 {

    private EntityManager em;
    private EntityTransaction tx;

    @BeforeEach
    void setUp() {
        em = JPAUtil.getEntityManager();
        tx = em.getTransaction();
        System.out.println("\n=== TEST 5: Bi M:N ===\n");
    }

    @AfterEach
    void tearDown() {
        if (tx.isActive()) tx.rollback();
        if (em.isOpen()) em.close();
    }

    @Test
    void testManyToMany() {

        tx.begin();

        Doctor doc = new Doctor();
        doc.setName("Dr Adams");

        Patient p1 = new Patient();
        p1.setName("Ravi");
        p1.setDob(LocalDate.of(1998,5,10));

        doc.addPatient(p1);

        em.persist(doc);
        Long id = doc.getId();
        tx.commit();

        em.clear();
        Doctor loaded = em.find(Doctor.class,id);

        assertEquals(1, loaded.getPatients().size());
    }
}