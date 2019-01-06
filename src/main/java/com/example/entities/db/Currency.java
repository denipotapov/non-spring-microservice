package com.example.entities.db;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "CURRENCIES",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "CURRENCY_CODE")
        })
@EqualsAndHashCode
public class Currency {

    @Id
    @GenericGenerator(name = "CURRENCY_SEQ", strategy = "enhanced-sequence")
    @GeneratedValue(generator = "CURRENCY_SEQ")
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "ID")
    private long id;

    @Version
    @Column(name = "VERSION")
    private long version;

    @NotBlank
    @Column(name = "CURRENCY_NAME")
    private String currencyName;

    @NotNull
    @Column(name = "CURRENCY_CODE")
    private int code;

}
