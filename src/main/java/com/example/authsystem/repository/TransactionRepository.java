package com.example.authsystem.repository;

import com.example.authsystem.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findTop3ByFromAccountOrToAccountOrderByDateDesc(String fromAccount, String toAccount);
}
