package com.example.authsystem.service;

import com.example.authsystem.model.Account;
import com.example.authsystem.repository.AccountRepository;
import com.example.authsystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public double getBalance(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        return account != null ? account.getBalance() : 0.0;
    }

    public List<?> getMiniStatement(String accountNumber) {
        return transactionRepository.findTop3ByFromAccountOrToAccountOrderByDateDesc(accountNumber, accountNumber);
    }
}
