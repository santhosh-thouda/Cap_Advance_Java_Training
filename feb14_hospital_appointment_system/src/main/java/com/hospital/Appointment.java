package com.hospital;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate visitDate;
    private double fee;

    @ManyToOne
    private Patient patient;

    public int getId() { return id; }

    public LocalDate getVisitDate() { return visitDate; }
    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
