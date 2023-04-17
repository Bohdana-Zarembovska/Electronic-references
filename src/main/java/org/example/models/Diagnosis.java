package org.example.models;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "doc_id", nullable = false)
    private Doctor doctor;

    @Column(name = "symptoms", nullable = false)
    private String symptoms;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", symptoms='" + symptoms  +
                ", patient=" + patient +
                ", date=" + date +
                '}';
    }

    //constructor
    public Diagnosis(Doctor doctor, String symptoms, Patient patient, LocalDate date) {
        this.doctor = doctor;
        this.symptoms = symptoms;
        this.patient = patient;
        this.date = date;
    }
}
