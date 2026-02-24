package com.pismo.transactions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountResponse {

    @JsonProperty("account_id")
    private Long accountId;

    @JsonProperty("document_number")
    private String documentNumber;

    @JsonProperty("credit_limit")
    private Double creditLimit;

    public AccountResponse(Long accountId, String documentNumber, Double creditLimit) {
        this.accountId = accountId;
        this.documentNumber = documentNumber;
        this.creditLimit = creditLimit;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }
}
