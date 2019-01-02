package com.example.entities.rest;

import lombok.Data;

@Data
public class TransferMoneyPayload {

    private long fromAccount;
    private long toAccount;
    private int amount;

}
