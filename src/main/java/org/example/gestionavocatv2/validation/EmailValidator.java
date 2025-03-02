package org.example.gestionavocatv2.validation;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    private static final String EMAIL_PATTERN =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    @Override
    public void initialize(final ValidEmail constraintAnnotation) {
        // No initialization required
    }

    @Override
    public boolean isValid(final String email, final ConstraintValidatorContext context) {
        return (email != null && pattern.matcher(email).matches());
    }
}

