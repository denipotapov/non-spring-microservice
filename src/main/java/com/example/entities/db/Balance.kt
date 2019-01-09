package com.example.entities.db

import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.Generated
import org.hibernate.annotations.GenerationTime.INSERT
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class Balance(
        @Generated(INSERT)
        @ColumnDefault("0")
        @Column(name = "BALANCE_AMOUNT", insertable = false)
        var amount: Int)