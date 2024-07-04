package com.example.bankapplication.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Account implements Serializable {
    @Id
    private String accountNumber;
    private String customerName;
    private double balanceAmount;

    @OneToOne(mappedBy = "account")
    private Transactions transactions;

    // Getters and Setters

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public Transactions getTransactions() {
        return transactions;
    }

    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }
}
