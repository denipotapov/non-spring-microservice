package com.example.exceptions;

public class DifferentTransferCurrenciesException extends Throwable {

    public DifferentTransferCurrenciesException(){
        super("Trying to transfer among accounts different with different currencies");
    }
}
