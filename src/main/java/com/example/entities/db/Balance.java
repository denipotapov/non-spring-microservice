package com.example.entities.db;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Data
@Embeddable
public class Balance {

    @NotNull
    @Column(name = "BALANCE_AMOUNT")
    private int amount;

}
