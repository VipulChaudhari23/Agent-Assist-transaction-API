package com.AgentAssist.Demo.AgentAssist.repositories;

import com.AgentAssist.Demo.AgentAssist.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepo extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountNumber(Long accountNumber);
}
