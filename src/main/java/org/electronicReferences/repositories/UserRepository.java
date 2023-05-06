package org.electronicReferences.repositories;
import org.electronicReferences.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findAll(Specification<User> spec, Pageable pageable);
}