package com.example.exceptions;

public class InsufficientFundsException extends RuntimeException {

    public InsufficientFundsException() {
        super("Low balance to make a transfer");
    }
}
