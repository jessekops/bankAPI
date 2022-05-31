package io.swagger.service;


import io.swagger.model.entity.Account;
import io.swagger.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AccountIbanGenService extends AccountService {
    @Autowired
    private AccountRepo accountRepo;

    public String generateIban() {
        StringBuilder iban = new StringBuilder("NL");
        Random prefix = new Random();
        int max = 100;
        int min = 10;
        iban.append(prefix.nextInt(max-min));
        iban.append("INHO");
        long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        iban.append(number);

        String finalIban = iban.toString();

        return  finalIban;
    }
}
