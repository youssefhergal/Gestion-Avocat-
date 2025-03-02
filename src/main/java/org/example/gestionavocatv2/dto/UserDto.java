package org.example.gestionavocatv2.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.gestionavocatv2.validation.PasswordMatches;
import org.example.gestionavocatv2.validation.ValidEmail;
import org.example.gestionavocatv2.validation.ValidPassword;

@Getter
@Setter
@PasswordMatches
public class UserDto {

    @NotNull
    @Size(min = 1, message = "{Size.userDto.firstName}")
    private String firstName;

    @NotNull
    @Size(min = 1, message = "{Size.userDto.lastName}")
    private String lastName;

    @ValidPassword
    private String password;

    @NotNull
    @Size(min = 1)
    private String matchingPassword;

    @ValidEmail
    @NotNull
    @Size(min = 1, message = "{Size.userDto.email}")
    private String email;

    @NotNull
    @Size(min = 10, message = "{Size.userDto.tel}")
    private String tel;

    private boolean isUsing2FA;

    private Integer role;

    @Override
    public String toString() {
        return "UserDto [firstName=" + firstName + ", lastName=" + lastName +
                ", password=" + password + ", matchingPassword=" + matchingPassword +
                ", email=" + email + ", tel=" + tel +
                ", isUsing2FA=" + isUsing2FA + ", role=" + role + "]";
    }

    public @NotNull @Size(min = 1, message = "{Size.userDto.firstName}") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull @Size(min = 1, message = "{Size.userDto.firstName}") String firstName) {
        this.firstName = firstName;
    }

    public @NotNull @Size(min = 1, message = "{Size.userDto.lastName}") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull @Size(min = 1, message = "{Size.userDto.lastName}") String lastName) {
        this.lastName = lastName;
    }

    public @NotNull @Size(min = 1) String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(@NotNull @Size(min = 1) String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public @NotNull @Size(min = 10, message = "{Size.userDto.tel}") String getTel() {
        return tel;
    }

    public void setTel(@NotNull @Size(min = 10, message = "{Size.userDto.tel}") String tel) {
        this.tel = tel;
    }

    public @NotNull @Size(min = 1, message = "{Size.userDto.email}") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Size(min = 1, message = "{Size.userDto.email}") String email) {
        this.email = email;
    }

    public boolean isUsing2FA() {
        return isUsing2FA;
    }

    public void setUsing2FA(boolean using2FA) {
        isUsing2FA = using2FA;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
