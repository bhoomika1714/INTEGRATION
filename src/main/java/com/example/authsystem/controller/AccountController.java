package com.example.authsystem.controller;

import com.example.authsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{accountNumber}/balance")
    public double getBalance(@PathVariable String accountNumber) {
        return accountService.getBalance(accountNumber);
    }

    @GetMapping("/{accountNumber}/mini-statement")
    public Object getMiniStatement(@PathVariable String accountNumber) {
        return accountService.getMiniStatement(accountNumber);
    }
}
