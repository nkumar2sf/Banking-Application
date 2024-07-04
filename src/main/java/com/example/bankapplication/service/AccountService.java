package com.example.bankapplication.service;

import com.example.bankapplication.entity.Account;
import com.example.bankapplication.entity.Transactions;
import com.example.bankapplication.repository.AccountRepository;
import com.example.bankapplication.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Transactional
    public Account createAccount(Account account) {
        account.setAccountNumber(generateAccountNumber());
        account.setBalanceAmount(0);
        return accountRepository.save(account);
    }

    public Account deposit(String accountNumber, double amount) throws Exception {
        Optional<Account> accountOptional = accountRepository.findById(accountNumber);
        if (!accountOptional.isPresent()) {
            throw new Exception("Account not found");
        }
        Account account = accountOptional.get();
        account.setBalanceAmount(account.getBalanceAmount() + amount);
        accountRepository.save(account);

        Transactions transaction = new Transactions();
        transaction.setAccountNumber(accountNumber);
        transaction.setTransactionDate(new Date());
        transaction.setDescription("Deposit");
        transaction.setDeposit(amount);
        transaction.setBalance(account.getBalanceAmount());
        transactionsRepository.save(transaction);

        return account;
    }

    public Account withdraw(String accountNumber, double amount) throws Exception {
        Optional<Account> accountOptional = accountRepository.findById(accountNumber);
        if (!accountOptional.isPresent()) {
            throw new Exception("Account not found");
        }
        Account account = accountOptional.get();
        if (account.getBalanceAmount() < amount) {
            throw new Exception("Insufficient balance");
        }
        account.setBalanceAmount(account.getBalanceAmount() - amount);
        accountRepository.save(account);

        Transactions transaction = new Transactions();
        transaction.setAccountNumber(accountNumber);
        transaction.setTransactionDate(new Date());
        transaction.setDescription("Withdraw");
        transaction.setWithdraw(amount);
        transaction.setBalance(account.getBalanceAmount());
        transactionsRepository.save(transaction);

        return account;
    }

    public double checkBalance(String accountNumber) throws Exception {
        Optional<Account> accountOptional = accountRepository.findById(accountNumber);
        if (!accountOptional.isPresent()) {
            throw new Exception("Account not found");
        }
        return accountOptional.get().getBalanceAmount();
    }

    private String generateAccountNumber() {
        return "ACC" + System.currentTimeMillis();
    }
}
