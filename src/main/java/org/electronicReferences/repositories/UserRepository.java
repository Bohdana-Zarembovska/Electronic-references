package org.electronicReferences.repositories;
import org.electronicReferences.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}