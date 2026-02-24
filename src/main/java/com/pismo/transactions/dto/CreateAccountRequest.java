package com.pismo.transactions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAccountRequest {

    @JsonProperty("document_number")
    private String documentNumber;

    @JsonProperty("credit_limit")
    private double creditLimit;

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
