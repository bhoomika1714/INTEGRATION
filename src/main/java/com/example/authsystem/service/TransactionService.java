package com.example.authsystem.service;

import com.example.authsystem.model.Account;
import com.example.authsystem.model.Transaction;
import com.example.authsystem.repository.AccountRepository;
import com.example.authsystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public String sendMoney(String fromAccount, String toAccount, double amount) {
        Account sender = accountRepository.findByAccountNumber(fromAccount);
        Account receiver = accountRepository.findByAccountNumber(toAccount);

        if (sender == null || receiver == null || sender.getBalance() < amount) {
            return "Transaction Failed!";
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        accountRepository.save(sender);
        accountRepository.save(receiver);

        Transaction transaction = new Transaction();
        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);
        transaction.setAmount(amount);
        transaction.setStatus("Success");
        transaction.setDate(new Date());

        transactionRepository.save(transaction);

        return "Transaction Successful!";
    }

    public String requestMoney(String requesterAccount, String requesteeAccount, double amount) {
        Transaction transaction = new Transaction();
        transaction.setFromAccount(requesteeAccount);
        transaction.setToAccount(requesterAccount);
        transaction.setAmount(amount);
        transaction.setStatus("Requested");
        transaction.setDate(new Date());

        transactionRepository.save(transaction);
        return "Money Request Sent!";
    }

    public String receiveMoney(String fromAccount, String toAccount, double amount) {
        return sendMoney(fromAccount, toAccount, amount);
    }

    public List<Transaction> getMiniStatement(String accountNumber) {
        return transactionRepository.findTop3ByFromAccountOrToAccountOrderByDateDesc(accountNumber, accountNumber);
    }
}
