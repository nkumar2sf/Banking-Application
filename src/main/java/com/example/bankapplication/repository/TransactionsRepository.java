package com.example.bankapplication.repository;

import com.example.bankapplication.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Date;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
    List<Transactions> findByAccountNumber(String accountNumber);
    List<Transactions> findByAccountNumberAndTransactionDateBetween(String accountNumber, Date startDate, Date endDate);
}
