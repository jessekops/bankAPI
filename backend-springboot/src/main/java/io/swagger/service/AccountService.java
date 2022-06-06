package io.swagger.service;

import io.swagger.model.entity.Account;
import io.swagger.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

    public Account addAccount(Account a) {
        return accountRepo.save(a);
    }


    public List<Account> findAccountsByUserId(UUID userId) {
        return accountRepo.findAccountsByUserId(userId);
    }

    public Account updateAccount(Account updatedAccount){
        return accountRepo.save(updatedAccount);
    }
    public Account findAccountByIban(String iban) {
        return accountRepo.findAccountByIban(iban);
    }
    public List<Account> getAll() {
        return accountRepo.findAll();
    }
}
