package com.github.paulosalonso.customer.adapter.repository.postalcode;

public class InvalidPostalCodeException extends RuntimeException {
    public InvalidPostalCodeException(String message) {
        super(message);
    }
}
