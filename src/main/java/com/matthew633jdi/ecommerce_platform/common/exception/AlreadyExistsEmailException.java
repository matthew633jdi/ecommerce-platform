package com.matthew633jdi.ecommerce_platform.common.exception;

public class AlreadyExistsEmailException extends RuntimeException {
    private static final String MESSAGE = "Email already exists";
    public AlreadyExistsEmailException() {
        super(MESSAGE);
    }
}
