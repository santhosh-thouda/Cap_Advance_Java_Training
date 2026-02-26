package com.hms.test;

import com.hms.entity.*;
import com.hms.util.JPAUtil;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CRUDTest2 {

    private EntityManager em;
    private EntityTransaction tx;

    @BeforeEach
    void setUp() {
        em = JPAUtil.getEntityManager();
        tx = em.getTransaction();
        System.out.println("\n=== TEST 2: Bi 1:N ===\n");
    }

    @AfterEach
    void tearDown() {
        if (tx.isActive()) tx.rollback();
        if (em.isOpen()) em.close();
    }

    @Test
    void testBidirectionalOneToMany() {

        tx.begin();
        Department dept = new Department();
        dept.setName("Cardiology");

        Doctor d1 = new Doctor();
        d1.setName("Dr A");

        Doctor d2 = new Doctor();
        d2.setName("Dr B");

        dept.addDoctor(d1);
        dept.addDoctor(d2);

        em.persist(dept);
        Long id = dept.getId();
        tx.commit();

        em.clear();
        Department loaded = em.find(Department.class,id);

        assertEquals(2, loaded.getDoctors().size());

        List<Doctor> result =
                em.createQuery("SELECT d FROM Doctor d WHERE d.department.name=:name",
                        Doctor.class)
                        .setParameter("name","Cardiology")
                        .getResultList();

        assertEquals(2,result.size());
    }
}