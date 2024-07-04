package com.example.bankapplication.controller;

import com.example.bankapplication.entity.Account;
import com.example.bankapplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    @PostMapping("/deposit")
    public ResponseEntity<Account> deposit(@RequestParam String accountNumber, @RequestParam double amount) {
        try {
            return ResponseEntity.ok(accountService.deposit(accountNumber, amount));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Account> withdraw(@RequestParam String accountNumber, @RequestParam double amount) {
        try {
            return ResponseEntity.ok(accountService.withdraw(accountNumber, amount));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/balance")
    public ResponseEntity<Double> checkBalance(@RequestParam String accountNumber) {
        try {
            return ResponseEntity.ok(accountService.checkBalance(accountNumber));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
