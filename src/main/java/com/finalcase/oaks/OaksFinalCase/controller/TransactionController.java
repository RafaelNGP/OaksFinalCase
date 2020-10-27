package com.finalcase.oaks.OaksFinalCase.controller;

import com.finalcase.oaks.OaksFinalCase.entity.Transaction;
import com.finalcase.oaks.OaksFinalCase.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService service;

    @GetMapping("/all")
    public List<Transaction> getAllTransaction() {
        return service.getAllTransactions();
    }

    @PostMapping("/save")
    public Transaction saveTransaction(@RequestBody String merchant, @RequestBody Date time, @RequestBody int amount) {
        return service.saveTransaction(merchant, amount, time);
    }

    public List<Transaction> getAllByMerchant(@RequestBody String merchant) {
        return service.getAllByMerchant(merchant);
    }
}
