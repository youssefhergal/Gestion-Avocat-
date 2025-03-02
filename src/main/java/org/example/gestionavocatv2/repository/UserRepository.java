package org.example.gestionavocatv2.repository;

import org.example.gestionavocatv2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findByFirstNameContaining(String firstName);
}
