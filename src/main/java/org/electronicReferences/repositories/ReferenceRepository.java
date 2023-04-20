package org.electronicReferences.repositories;
import org.electronicReferences.models.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceRepository extends JpaRepository<Reference, Integer> {

}
