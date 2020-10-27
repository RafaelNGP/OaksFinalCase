package com.finalcase.oaks.OaksFinalCase.service;

import com.finalcase.oaks.OaksFinalCase.entity.Account;
import com.finalcase.oaks.OaksFinalCase.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccount(){
        return accountRepository.getOne(1);
    }

    public void saveAccount(Account account){
        accountRepository.save(account);
    }
}
