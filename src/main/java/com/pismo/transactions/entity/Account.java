package com.pismo.transactions.entity;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(nullable = false)
    private String documentNumber;

    @Column
    private Double creditLimit;

    @Version
    private Integer version;


    public Account() {
    }

    public Account(String documentNumber) {
        this.documentNumber = documentNumber;
        this.creditLimit = Double.valueOf(0);
    }

    public Account(String documentNumber, Double creditLimit) {
        this.documentNumber = documentNumber;
        this.creditLimit = creditLimit;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }
}
