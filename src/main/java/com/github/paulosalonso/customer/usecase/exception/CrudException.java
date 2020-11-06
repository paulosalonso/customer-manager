package com.github.paulosalonso.customer.usecase.exception;

public class CrudException extends RuntimeException {
    public CrudException() {}

    public CrudException(String message) {
        super(message);
    }

    public CrudException(String message, Throwable cause) {
        super(message, cause);
    }
}
