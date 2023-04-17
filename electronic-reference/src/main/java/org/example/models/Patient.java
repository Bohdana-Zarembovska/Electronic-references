package org.example.models;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_type")
    private BloodType bloodType;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", bloodType=" + bloodType +
                ", birthDate=" + birthDate +
                ", sex=" + sex +
                ", address='" + address + '}';
    }

    public Patient( BloodType bloodType, Date birthDate, Sex sex, String address) {
        this.bloodType = bloodType;
        this.birthDate = birthDate;
        this.sex = sex;
        this.address = address;
    }
}

enum BloodType {
    AB_POSITIVE, AB_NEGATIVE, A_POSITIVE, A_NEGATIVE, B_POSITIVE, B_NEGATIVE, O_POSITIVE, O_NEGATIVE;
}

enum Sex {
    MALE, FEMALE, OTHER;
}