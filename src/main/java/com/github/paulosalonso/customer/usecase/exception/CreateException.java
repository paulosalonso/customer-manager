package com.github.paulosalonso.customer.usecase.exception;

public class CreateException extends CrudException {
    public CreateException(String message) {
        super(message);
    }
}
