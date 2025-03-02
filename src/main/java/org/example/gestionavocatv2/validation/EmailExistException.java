package org.example.gestionavocatv2.validation;


public class EmailExistException extends Exception {

    public EmailExistException(final String message) {
        super(message);
    }
}

