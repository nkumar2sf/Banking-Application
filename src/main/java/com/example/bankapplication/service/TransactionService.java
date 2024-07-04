package com.example.bankapplication.service;

import com.example.bankapplication.entity.Transactions;
import com.example.bankapplication.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionsRepository transactionsRepository;

    public List<Transactions> getTransactionsByAccountNumber(String accountNumber) {
        return transactionsRepository.findByAccountNumber(accountNumber);
    }

    public List<Transactions> getTransactionsByAccountNumberAndDate(String accountNumber, Date startDate, Date endDate) {
        return transactionsRepository.findByAccountNumberAndTransactionDateBetween(accountNumber, startDate, endDate);
    }
}
