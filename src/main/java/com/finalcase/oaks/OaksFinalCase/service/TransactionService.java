package com.finalcase.oaks.OaksFinalCase.service;

import com.finalcase.oaks.OaksFinalCase.entity.Transaction;
import com.finalcase.oaks.OaksFinalCase.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class TransactionService {

    @Autowired
    TransactionRepository repository;

    public Transaction getTransactionsById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public Transaction saveTransaction(String merchant, int amount, Date time) {
        Transaction transaction = new Transaction(merchant, amount, time);
        return transaction;
    }

    public List<Transaction> getAllByMerchant(String merchant) {
        return repository.findByMerchant(merchant);
    }

}
