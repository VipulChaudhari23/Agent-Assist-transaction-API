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
@Table(name = "Accounts")
public class Account {
        @Id
        private Long accountNumber;
        private String accountType;
        private BigDecimal balance;
        private Long customerId;
        private LocalDateTime creationDate;

}
