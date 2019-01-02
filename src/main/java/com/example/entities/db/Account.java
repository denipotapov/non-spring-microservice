package com.example.entities.db;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "ACCOUNTS")
@ToString
public class Account {

    @Id
    @GenericGenerator(name = "ACCOUNT_SEQ", strategy = "increment")
    @GeneratedValue(generator = "ACCOUNT_SEQ")
    @Column(name = "ID")
    @Setter(AccessLevel.PRIVATE)
    private long id;

    @Version
    @Column(name = "VERSION")
    @Getter
    private long version;

    @NotNull
    @Column(name = "OPEN_DATE", updatable = false)
    @Setter
    @Getter
    private Timestamp openDate;

    @Column(name = "CLOSE_DATE", insertable = false)
    @Setter
    @Getter
    private Timestamp closeDate;

    @Embedded
    @Setter
    @Getter
    private Balance balance;

    @ManyToOne
    @JoinColumn(name = "CURRENCY_ID", updatable = false)
    @NotNull
    @Setter
    @Getter
    private Currency currency;

}
