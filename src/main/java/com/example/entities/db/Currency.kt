package com.example.entities.db

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Immutable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.UniqueConstraint
import javax.persistence.Version
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name = "CURRENCIES", uniqueConstraints = [UniqueConstraint(columnNames = arrayOf("CURRENCY_CODE"))])
@Immutable
data class Currency(
        @Id
        @GenericGenerator(name = "CURRENCY_SEQ", strategy = "enhanced-sequence")
        @GeneratedValue(generator = "CURRENCY_SEQ")
        @Column(name = "ID")
        val id: Long,

        @NotBlank
        @Column(name = "CURRENCY_NAME")
        var currencyName: String,

        @NotNull
        @Column(name = "CURRENCY_CODE")
        var code: Int,

        @Version
        @Column(name = "VERSION")
        val version: Long
)
