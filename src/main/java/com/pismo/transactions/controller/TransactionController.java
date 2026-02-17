package com.pismo.transactions.controller;

import com.pismo.transactions.dto.CreateTransactionRequest;
import com.pismo.transactions.dto.TransactionResponse;
import com.pismo.transactions.entity.Transaction;
import com.pismo.transactions.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionResponse> createTransaction(@RequestBody CreateTransactionRequest request) {
        Transaction transaction = transactionService.createTransaction(
                request.getAccountId(), request.getOperationTypeId(), request.getAmount());

        TransactionResponse response = new TransactionResponse(
                transaction.getTransactionId(),
                transaction.getAccount().getAccountId(),
                transaction.getOperationType().getOperationTypeId(),
                transaction.getAmount(),
                transaction.getEventDate().toString());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
