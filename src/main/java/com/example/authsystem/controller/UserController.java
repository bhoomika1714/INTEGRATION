package com.example.authsystem.controller;

import com.example.authsystem.model.Transaction;
import com.example.authsystem.service.AccountService;
import com.example.authsystem.service.TransactionService;
import com.example.authsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    // 1. Send Money
    @PostMapping("/sendMoney")
    public String sendMoney(@RequestParam String fromAccount,
                            @RequestParam String toAccount,
                            @RequestParam double amount) {
        return transactionService.sendMoney(fromAccount, toAccount, amount);
    }

    // 2. Request Money
    @PostMapping("/requestMoney")
    public String requestMoney(@RequestParam String requesterAccount,
                               @RequestParam String requesteeAccount,
                               @RequestParam double amount) {
        return transactionService.requestMoney(requesterAccount, requesteeAccount, amount);
    }

    // 3. Receive Money
    @PostMapping("/receiveMoney")
    public String receiveMoney(@RequestParam String fromAccount,
                               @RequestParam String toAccount,
                               @RequestParam double amount) {
        return transactionService.receiveMoney(fromAccount, toAccount, amount);
    }

    // 4. Check Balance
    @GetMapping("/checkBalance/{accountNumber}")
    public double checkBalance(@PathVariable String accountNumber) {
        return accountService.getBalance(accountNumber);
    }

    // 5. Get Mini Statement
    @GetMapping("/miniStatement/{accountNumber}")
    public List<?> getMiniStatement(@PathVariable String accountNumber) {
        return accountService.getMiniStatement(accountNumber);
    }
}
