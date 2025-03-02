package org.example.gestionavocatv2.service;


import org.example.gestionavocatv2.entity.PasswordResetToken;
import org.example.gestionavocatv2.entity.User;
import org.example.gestionavocatv2.dto.UserDto;
import org.example.gestionavocatv2.entity.VerificationToken;
import org.example.gestionavocatv2.exception.UserAlreadyExistException;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;


public interface IUserService {

    User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException;

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    void deleteUser(User user);

    void createVerificationTokenForUser(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    VerificationToken generateNewVerificationToken(String token);

    void createPasswordResetTokenForUser(User user, String token);

    User findUserByEmail(String email);

    PasswordResetToken getPasswordResetToken(String token);

    User getUserByPasswordResetToken(String token);

    Optional<User> getUserByID(long id);

    void changeUserPassword(User user, String password);

    boolean checkIfValidOldPassword(User user, String password);

    String validateVerificationToken(String token);

    String generateQRUrl(User user) throws UnsupportedEncodingException;

    User updateUser2FA(boolean use2FA);

    List<String> getUsersFromSessionRegistry();

    List<User> findAll();

    User addUser(User user);

    User findById(Long id);

    List<User> findByFirstName(String firstName);

    List<User> findByfirstName(String mu);
}
