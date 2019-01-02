package com.example.exceptions;

public class AccountNotFoundException extends Throwable {

    public AccountNotFoundException(long accountId) {
        super(String.format("Account with id %d was not found", accountId));
    }
}
