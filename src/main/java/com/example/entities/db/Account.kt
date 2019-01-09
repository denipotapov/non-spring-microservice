package com.example.entities.db

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import java.sql.Timestamp
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.Version
import javax.validation.constraints.NotNull
import javax.validation.constraints.PastOrPresent

@Entity
@Table(name = "ACCOUNTS")
data class Account(
        @Id
        @GenericGenerator(name = "ACCOUNT_SEQ",
                strategy = "enhanced-sequence",
                parameters = [
                    Parameter(name = "initial_value", value = "1"),
                    Parameter(name = "increment_size", value = "1")]
        )
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_ID")
        @Column(name = "ID", updatable = false)
        val id: Long,

        @NotNull
        @Column(name = "ACCOUNT_TYPE")
        var type: AccountType,

        @NotNull
        @CreationTimestamp
//        @Generated(GenerationTime.INSERT)
        @Column(name = "OPEN_DATE", updatable = false)
        var openDate: Timestamp,

        @PastOrPresent
        @Column(name = "CLOSE_DATE", insertable = false)
        var closeDate: Timestamp,

        @Embedded
        var balance: Balance,

        @ManyToOne
        @JoinColumn(name = "CURRENCY_ID", updatable = false)
        @NotNull
        var currency: Currency,

        @Version
        @Column(name = "VERSION")
        val version: Long
)
