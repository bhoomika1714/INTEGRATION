package com.example.authsystem.controller;

import com.example.authsystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/send")
    public String sendMoney(@RequestParam String fromAccount,
                            @RequestParam String toAccount,
                            @RequestParam double amount) {
        return transactionService.sendMoney(fromAccount, toAccount, amount);
    }

    @PostMapping("/request")
    public String requestMoney(@RequestParam String requesterAccount,
                               @RequestParam String requesteeAccount,
                               @RequestParam double amount) {
        return transactionService.requestMoney(requesterAccount, requesteeAccount, amount);
    }

    @PostMapping("/receive")
    public String receiveMoney(@RequestParam String fromAccount,
                               @RequestParam String toAccount,
                               @RequestParam double amount) {
        return transactionService.receiveMoney(fromAccount, toAccount, amount);
    }
}
