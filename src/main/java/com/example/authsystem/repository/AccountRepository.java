package com.example.authsystem.repository;

import com.example.authsystem.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    Account findByAccountNumber(String accountNumber);
}
