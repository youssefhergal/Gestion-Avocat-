package org.example.gestionavocatv2.repository;

import org.example.gestionavocatv2.entity.PasswordResetToken;
import org.example.gestionavocatv2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findByUser(User user);

    PasswordResetToken findByToken(String token);
}
