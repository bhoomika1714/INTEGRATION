package com.example.authsystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")
public class Account {

    @Id
    private String accountNumber;
    private String userId;
    private double balance;

    public Account() {
    }

    public Account(String accountNumber, String userId, double balance) {
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.balance = balance;
    }

    // Getters and Setters

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", userId='" + userId + '\'' +
                ", balance=" + balance +
                '}';
    }
}
