package org.example.gestionavocatv2.repository;

import org.example.gestionavocatv2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String roleUser);
}
