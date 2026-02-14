package com.hospital;

import java.util.List;

public class HospitalService {

    PatientDAO patientDAO = new PatientDAO();
    DoctorDAO doctorDAO = new DoctorDAO();
    AppointmentDAO appointmentDAO = new AppointmentDAO();

    public void registerPatient(Patient patient) {
        patientDAO.savePatient(patient);
    }

    public void addAppointmentsToDoctor(Doctor doctor) {
        doctorDAO.saveDoctor(doctor);
    }

    public void assignAppointmentToPatient(Appointment appointment) {
        appointmentDAO.saveAppointment(appointment);
    }

    public void updateAppointmentFee(int id, double fee) {
        appointmentDAO.updateFee(id, fee);
    }

    public List<Appointment> getDoctorAppointments(int doctorId) {
        return appointmentDAO.findAppointmentByDoctor(doctorId);
    }

    public void deletePatient(int id) {
        patientDAO.deletePatient(id);
    }
}
