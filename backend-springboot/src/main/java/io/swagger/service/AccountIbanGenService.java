package io.swagger.service;


import io.swagger.model.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AccountIbanGenService extends AccountService {
    @Autowired
    private AccountService accountService;

    //pincode check for integer
    public boolean pinCheck(Integer pin) {
        return String.valueOf(pin).length() == 4;
    }

    public boolean allFieldsFilled(Account a) {
        return a.getBalance() != null && a.getIban() != null && a.getAccountType() != null && a.getUser() != null;
    }

    public String generateIban() {
        StringBuilder iban = new StringBuilder("NL");
        Random prefix = new Random();
        int max = 100;
        int min = 10;
        iban.append(prefix.nextInt(max - min) + min);
        iban.append("INHO");
        long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        iban.append(number);
        String finalIban = iban.toString();
        if (accountService.findAccountByIban(finalIban) != null){
            throw new IllegalArgumentException("Something went wrong generating your iban.");
        }

        return finalIban;

//            else {
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Something went wrong generating your iban.");
//            }
    }
}
