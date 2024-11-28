package com.AgentAssist.Demo.AgentAssist.controller;

import com.AgentAssist.Demo.AgentAssist.entities.Transaction;
import com.AgentAssist.Demo.AgentAssist.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    private final BankService bankService;
    private static final Logger logger = LoggerFactory.getLogger(BankController.class);

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/transactions/saving/{accountNumber}")
    public ResponseEntity<List<Transaction>> getRecentSavingTransactions(@PathVariable Long accountNumber) {
        logger.info("Fetching recent saving transactions for account number: {}", accountNumber);

        List<Transaction> transactions = bankService.getRecentTransactions(accountNumber, "Saving");
        logger.info("Retrieved transactions: {}", transactions);

        return transactions.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(transactions);
    }

    @GetMapping("/transactions/credit/{accountNumber}")
    public ResponseEntity<List<Transaction>> getRecentCreditCardTransactions(@PathVariable Long accountNumber) {
        logger.info("Fetching recent credit card transactions for account number: {}", accountNumber);

        List<Transaction> transactions = bankService.getRecentTransactions(accountNumber, "CreditCard");
        logger.info("Retrieved transactions: {}", transactions);

        return transactions.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(transactions);
    }

    @GetMapping("/transactions/recent-amount/{accountNumber}")
    public ResponseEntity<BigDecimal> getRecentTransactionAmount(@PathVariable Long accountNumber) {
        logger.info("Fetching recent transaction amount for account number: {}", accountNumber);

        return bankService.getRecentTransactionAmount(accountNumber)
                .map(transaction -> {
                    logger.info("Retrieved transaction amount: {}", transaction.getTransactionAmount());
                    return ResponseEntity.ok(transaction.getTransactionAmount());
                })
                .orElseGet(() -> {
                    logger.warn("No recent transaction amount found for account number: {}", accountNumber);
                    return ResponseEntity.noContent().build();
                });
    }

    @GetMapping("/balance/{accountNumber}")
    public ResponseEntity<BigDecimal> getBankBalance(@PathVariable Long accountNumber) {
        logger.info("Fetching bank balance for account number: {}", accountNumber);

        return bankService.checkBankBalance(accountNumber)
                .map(balance -> {
                    logger.info("Retrieved balance: {}", balance);
                    return ResponseEntity.ok(balance);
                })
                .orElseGet(() -> {
                    logger.warn("No balance found for account number: {}", accountNumber);
                    return ResponseEntity.noContent().build();
                });
    }
}
