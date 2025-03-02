package org.example.gestionavocatv2.repository;

import org.example.gestionavocatv2.entity.User;
import org.example.gestionavocatv2.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String verificationToken);

    Optional<VerificationToken> findByUser(User user);
}
