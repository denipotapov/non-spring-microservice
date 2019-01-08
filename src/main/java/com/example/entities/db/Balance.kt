package com.example.entities.db

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.validation.constraints.NotNull

@Embeddable
data class Balance(
        @NotNull
        @Column(name = "BALANCE_AMOUNT")
        var amount: Int? = null)