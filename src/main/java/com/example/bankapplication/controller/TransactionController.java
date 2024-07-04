package com.example.bankapplication.controller;

import com.example.bankapplication.entity.Transactions;
import com.example.bankapplication.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/byAccountNumber")
    public ResponseEntity<List<Transactions>> getTransactionsByAccountNumber(@RequestParam String accountNumber) {
        return ResponseEntity.ok(transactionService.getTransactionsByAccountNumber(accountNumber));
    }

    @GetMapping("/byAccountNumberAndDate")
    public ResponseEntity<List<Transactions>> getTransactionsByAccountNumberAndDate(@RequestParam String accountNumber, @RequestParam Date startDate, @RequestParam Date endDate) {
        return ResponseEntity.ok(transactionService.getTransactionsByAccountNumberAndDate(accountNumber, startDate, endDate));
    }
}
