package com.javatrap2020.patient.exeption;

public class PatientNotFoundException extends RuntimeException {

    private static final String MESSAGE_DOESNT = "This patient doesn't exist";

    public PatientNotFoundException() {
        super(MESSAGE_DOESNT);
    }
}
