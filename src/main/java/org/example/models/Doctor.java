package org.example.models;
import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "specification")
    private String specification;

    @Column(name = "hospital_name")
    private String hospitalName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    // toString
    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", specification='" + specification + ' ' +
                ", hospitalName='" + hospitalName + ' ' +
                '}';
    }

    public Doctor( String specification, String hospitalName) {
        this.specification = specification;
        this.hospitalName = hospitalName;
    }
}
