package com.hms.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hms.entity.MedicalRecord;
import com.hms.entity.Patient;
import com.hms.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CRUDTest1 {

    private EntityManager em;
    private EntityTransaction tx;

    @BeforeEach
    void setUp() {
        em = JPAUtil.getEntityManager();
        tx = em.getTransaction();
        System.out.println("\n=== TEST 1: Uni 1:1 ===\n");
    }

    @AfterEach
    void tearDown() {
        if (tx.isActive()) tx.rollback();
        if (em.isOpen()) em.close();
    }

    @Test
    void testPatientMedicalRecordCRUD() {

        tx.begin();
        MedicalRecord record = new MedicalRecord();
        record.setRecordDate(LocalDate.now());
        record.setDiagnosis("Flu");
        record.setNotes("Rest");

        Patient patient = new Patient();
        patient.setName("Santhosh");
        patient.setDob(LocalDate.of(2004,7,13));
        patient.setMedicalRecord(record);

        em.persist(patient);
        Long id = patient.getId();
        tx.commit();

        em.clear();
        Patient loaded = em.find(Patient.class, id);
        assertEquals("Flu",
                loaded.getMedicalRecord().getDiagnosis());

        tx.begin();
        loaded.getMedicalRecord().setNotes("Updated");
        tx.commit();

        em.clear();
        assertEquals("Updated",
                em.find(Patient.class,id)
                        .getMedicalRecord().getNotes());

        tx.begin();
        em.remove(em.find(Patient.class,id));
        tx.commit();

        assertNull(em.find(Patient.class,id));
    }
}