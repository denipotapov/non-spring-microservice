package com.example.entities.rest

class TransferMoneyPayload(
        var fromAccount: Long? = null,
        var toAccount: Long? = null,
        var amount: Int? = null
)