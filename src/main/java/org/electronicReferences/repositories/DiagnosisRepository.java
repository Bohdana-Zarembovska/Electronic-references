package org.electronicReferences.repositories;
import org.electronicReferences.models.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {

}
