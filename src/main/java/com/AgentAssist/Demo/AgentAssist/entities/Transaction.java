package com.AgentAssist.Demo.AgentAssist.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Transactions")
public class Transaction {
    @Id
    private Long transactionId;
    private Long customerId;
    private Long accountNumber;
    private BigDecimal transactionAmount;
    private String transactionType;  // "Saving" or "CreditCard"
    private LocalDateTime transactionDateTime;
    private String recipient;
}