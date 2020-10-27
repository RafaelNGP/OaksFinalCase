package com.finalcase.oaks.OaksFinalCase.controller;

import com.finalcase.oaks.OaksFinalCase.entity.Account;
import com.finalcase.oaks.OaksFinalCase.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public Account getAccount(){
        return accountService.getAccount();
    }

    @PostMapping
    public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
        return ResponseEntity.created(URI.create("/account")).body(account);
    }

}
