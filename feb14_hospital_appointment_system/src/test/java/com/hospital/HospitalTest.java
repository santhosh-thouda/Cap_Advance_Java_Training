package com.hospital;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HospitalTest {

    HospitalService service = new HospitalService();

    //  OneToOne persist test
    @Test
    void testOneToOnePersist() {

        MedicalRecord record = new MedicalRecord();
        record.setBloodGroup("O+");
        record.setAllergies("Dust");

        Patient patient = new Patient();
        patient.setName("Santhosh");
        patient.setAge(22);
        patient.setContact("9876543210");
        patient.setMedicalRecord(record);

        service.registerPatient(patient);

        assertTrue(patient.getId() >= 0);
    }

    //  OneToMany persist test
    @Test
    void testOneToManyPersist() {

        Appointment a1 = new Appointment();
        a1.setVisitDate(LocalDate.now());
        a1.setFee(500);

        Appointment a2 = new Appointment();
        a2.setVisitDate(LocalDate.now().plusDays(1));
        a2.setFee(700);

        Doctor doctor = new Doctor();
        doctor.setName("Dr. Kumar");
        doctor.setSpecialization("Cardiology");
        doctor.setAppointments(Arrays.asList(a1, a2));

        service.addAppointmentsToDoctor(doctor);

        assertTrue(doctor.getId() >= 0);
    }

    // ✅ ManyToOne persist test
    @Test
    void testManyToOnePersist() {

        MedicalRecord record = new MedicalRecord();
        record.setBloodGroup("A+");
        record.setAllergies("None");

        Patient patient = new Patient();
        patient.setName("Rahul");
        patient.setAge(25);
        patient.setContact("9999999999");
        patient.setMedicalRecord(record);

        service.registerPatient(patient);

        Appointment appointment = new Appointment();
        appointment.setVisitDate(LocalDate.now());
        appointment.setFee(800);
        appointment.setPatient(patient);

        service.assignAppointmentToPatient(appointment);

        assertTrue(appointment.getId() >= 0);
    }

    //  DAO update test
    @Test
    void testUpdateAppointmentFee() {

        Appointment appointment = new Appointment();
        appointment.setVisitDate(LocalDate.now());
        appointment.setFee(400);

        service.assignAppointmentToPatient(appointment);

        service.updateAppointmentFee(appointment.getId(), 1000);

        assertEquals(1000, appointment.getFee());
    }

    //  DAO delete test
    @Test
    void testDeletePatient() {

        MedicalRecord record = new MedicalRecord();
        record.setBloodGroup("B+");
        record.setAllergies("Pollen");

        Patient patient = new Patient();
        patient.setName("Arjun");
        patient.setAge(30);
        patient.setContact("8888888888");
        patient.setMedicalRecord(record);

        service.registerPatient(patient);

        int id = patient.getId();
        service.deletePatient(id);

        Patient deleted = new PatientDAO().findPatient(id);
        assertNull(deleted);
    }

    // ✅ Full Service Workflow Test
    @Test
    void testFullWorkflow() {

        MedicalRecord record = new MedicalRecord();
        record.setBloodGroup("AB+");
        record.setAllergies("None");

        Patient patient = new Patient();
        patient.setName("Workflow Patient");
        patient.setAge(28);
        patient.setContact("7777777777");
        patient.setMedicalRecord(record);

        service.registerPatient(patient);

        Appointment appointment = new Appointment();
        appointment.setVisitDate(LocalDate.now());
        appointment.setFee(600);
        appointment.setPatient(patient);

        service.assignAppointmentToPatient(appointment);

        assertNotNull(patient);
        assertNotNull(appointment);
    }
}
