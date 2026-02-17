package com.pismo.transactions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAccountRequest {

    @JsonProperty("document_number")
    private String documentNumber;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
