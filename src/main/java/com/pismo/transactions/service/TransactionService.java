package com.pismo.transactions.service;

import com.pismo.transactions.entity.Account;
import com.pismo.transactions.entity.OperationType;
import com.pismo.transactions.entity.Transaction;
import com.pismo.transactions.exception.ResourceNotFoundException;
import com.pismo.transactions.repository.AccountRepository;
import com.pismo.transactions.repository.OperationTypeRepository;
import com.pismo.transactions.repository.TransactionRepository;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final OperationTypeRepository operationTypeRepository;

    public TransactionService(TransactionRepository transactionRepository,
                              AccountRepository accountRepository,
                              OperationTypeRepository operationTypeRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.operationTypeRepository = operationTypeRepository;
    }

    public Transaction createTransaction(Long accountId, Long operationTypeId, Double amount) {
        if (accountId == null || operationTypeId == null || amount == null) {
            throw new IllegalArgumentException("account_id, operation_type_id, and amount are required");
        }

        if (amount == 0) {
            throw new IllegalArgumentException("amount must not be zero");
        }

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + accountId));

        OperationType operationType = operationTypeRepository.findById(operationTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("OperationType not found with id: " + operationTypeId));

        double adjustedAmount = adjustAmount(operationTypeId, amount);

        Transaction transaction = new Transaction(account, operationType, adjustedAmount, LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    /**
     * Purchases (1, 2) and withdrawals (3) are stored as negative amounts.
     * Payments (4) are stored as positive amounts.
     */
    private double adjustAmount(Long operationTypeId, double amount) {
        if (operationTypeId == 4) {
            return Math.abs(amount);
        }
        return -Math.abs(amount);
    }
}
