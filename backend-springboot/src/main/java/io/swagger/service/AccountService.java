package io.swagger.service;

import io.swagger.model.entity.Account;
import io.swagger.model.entity.User;
import io.swagger.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

    public Account addAccount(Account a) {
        a.setIban(generateIban());
        return accountRepo.save(a);
    }

    public String generateIban() {
        StringBuilder iban = new StringBuilder("NL");
        Random prefix = new Random();
        iban.append(prefix.nextInt(2-100));
        iban.append("INHO");
        long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        iban.append(number);

        String finalIban = iban.toString();

        return  finalIban;
    }

    public Account findAccountByUserId(UUID userId) {
        return accountRepo.findAccountByUserId(userId);
    }

    public Account updateAccount(Account updatedAccount){
        return accountRepo.save(updatedAccount);
    }


    public List<Account> getAll() {
        return accountRepo.findAll();
    }
}
