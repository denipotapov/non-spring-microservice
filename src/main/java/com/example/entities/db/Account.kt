package com.example.entities.db

import org.hibernate.annotations.Generated
import org.hibernate.annotations.GenerationTime.INSERT
import org.hibernate.annotations.GenericGenerator
import java.sql.Timestamp
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType.TIMESTAMP
import javax.persistence.Version
import javax.validation.constraints.NotNull
import javax.validation.constraints.PastOrPresent

@Entity
@Table(name = "ACCOUNTS")
data class Account(
        @Id
        @GenericGenerator(name = "ACCOUNT_SEQ", strategy = "enhanced-sequence")
        @GeneratedValue(generator = "ACCOUNT_SEQ")
        @Column(name = "ID")
        val id: Long? = null,

        @NotNull
        @Column(name = "ACCOUNT_TYPE")
        val type: AccountType? = null,

        @NotNull
        @Temporal(TIMESTAMP)
        @Generated(INSERT)
        @Column(name = "OPEN_DATE", updatable = false, insertable = false)
        var openDate: Timestamp? = null,

        @PastOrPresent
        @Temporal(TIMESTAMP)
        @Column(name = "CLOSE_DATE", insertable = false)
        var closeDate: Timestamp? = null,

        @Embedded
        var balance: Balance? = null,

        @ManyToOne
        @JoinColumn(name = "CURRENCY_ID", updatable = false)
        @NotNull
        var currency: Currency? = null,

        @Version
        @Column(name = "VERSION")
        val version: Long? = null)

