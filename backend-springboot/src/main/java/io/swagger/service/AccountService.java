package io.swagger.service;

import io.swagger.model.entity.Account;
import io.swagger.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

    public Account addAccount(Account a) {
        return accountRepo.save(a);
    }

    public Account findAccountByIban(String IBAN) {
        return accountRepo.findByIban(IBAN);
    }


    public List<Account> getAll() {
        return accountRepo.findAll();
    }
}
