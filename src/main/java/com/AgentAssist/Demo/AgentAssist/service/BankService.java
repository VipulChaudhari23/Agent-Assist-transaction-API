package com.AgentAssist.Demo.AgentAssist.service;

import com.AgentAssist.Demo.AgentAssist.entities.Account;
import com.AgentAssist.Demo.AgentAssist.entities.Transaction;
import com.AgentAssist.Demo.AgentAssist.repositories.AccountsRepo;
import com.AgentAssist.Demo.AgentAssist.repositories.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BankService {

    private final AccountsRepo accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public BankService(AccountsRepo accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    // Fetch recent transactions
    public List<Transaction> getRecentTransactions(Long accountNumber, String transactionType) {
        log.info("Fetching recent transactions for account number: {} and transaction type: {}", accountNumber, transactionType);

        // Query the repository for the most recent transactions
        List<Transaction> transactions = transactionRepository
                .findTop10ByAccountNumberAndTransactionTypeOrderByTransactionDateTimeDesc(accountNumber, transactionType);

        if (transactions.isEmpty()) {
            log.warn("No transactions found for account number: {} and transaction type: {}", accountNumber, transactionType);
        } else {
            log.info("Found {} transactions for account number: {} and transaction type: {}", transactions.size(), accountNumber, transactionType);
        }

        return transactions.stream().collect(Collectors.toList());
    }

    // Get most recent transaction amount
    public Optional<Transaction> getRecentTransactionAmount(Long accountNumber) {
        log.info("Fetching the most recent transaction for account number: {}", accountNumber);

        Optional<Transaction> transaction = transactionRepository.findTopByAccountNumberOrderByTransactionDateTimeDesc(accountNumber);

        if (transaction.isPresent()) {
            log.info("Found recent transaction for account number: {} with amount: {}", accountNumber, transaction.get().getTransactionAmount());
        } else {
            log.warn("No recent transaction found for account number: {}", accountNumber);
        }

        return transaction;
    }

    // Check bank balance
    public Optional<BigDecimal> checkBankBalance(Long accountNumber) {
        log.info("Fetching balance for account number: {}", accountNumber);

        Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);

        if (account.isPresent()) {
            log.info("Found balance for account number: {}: {}", accountNumber, account.get().getBalance());
            return Optional.of(account.get().getBalance());
        } else {
            log.warn("No account found for account number: {}", accountNumber);
            return Optional.empty();
        }
    }
}
