package com.pismo.transactions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionResponse {

    @JsonProperty("transaction_id")
    private Long transactionId;

    @JsonProperty("account_id")
    private Long accountId;

    @JsonProperty("operation_type_id")
    private Long operationTypeId;

    private Double amount;

    @JsonProperty("event_date")
    private String eventDate;

    public TransactionResponse(Long transactionId, Long accountId, Long operationTypeId,
                               Double amount, String eventDate) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.operationTypeId = operationTypeId;
        this.amount = amount;
        this.eventDate = eventDate;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Long getOperationTypeId() {
        return operationTypeId;
    }

    public Double getAmount() {
        return amount;
    }

    public String getEventDate() {
        return eventDate;
    }
}
