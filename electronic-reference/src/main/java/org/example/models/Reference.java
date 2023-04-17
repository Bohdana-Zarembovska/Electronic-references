package org.example.models;
import jakarta.persistence.*;

@Entity
@Table(name = "reference")
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String medicine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diagnos_id", referencedColumnName = "id")
    private Diagnosis diagnosis;

    @Column(name = "other_recommend")
    private String otherRecommend;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getOtherRecommend() {
        return otherRecommend;
    }

    public void setOtherRecommend(String otherRecommend) {
        this.otherRecommend = otherRecommend;
    }

    @Override
    public String toString() {
        return "Reference{" +
                "id=" + id +
                ", medicine='" + medicine +
                ", diagnosis=" + diagnosis +
                ", otherRecommend='" + otherRecommend +
                '}';
    }

    public Reference(String medicine, Diagnosis diagnosis, String otherRecommend) {
        this.medicine = medicine;
        this.diagnosis = diagnosis;
        this.otherRecommend = otherRecommend;
    }
}
