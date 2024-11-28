package com.AgentAssist.Demo.AgentAssist.repositories;

import com.AgentAssist.Demo.AgentAssist.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findTop10ByAccountNumberAndTransactionTypeOrderByTransactionDateTimeDesc(Long accountNumber, String transactionType);
    Optional<Transaction> findTopByAccountNumberOrderByTransactionDateTimeDesc(Long accountNumber);
}
