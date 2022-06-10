package io.swagger.service;


import io.swagger.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Random;

@Service
public class AccountIbanGenService extends AccountService {
    @Autowired
    private AccountRepo accountRepo;

    //pincode check for integer
    public boolean pinCheck(Integer pin) {
        return String.valueOf(pin).length() == 4;
    }
    public String generateIban() {
            StringBuilder iban = new StringBuilder("NL");
            Random prefix = new Random();
            int max = 100;
            int min = 10;
            iban.append(prefix.nextInt(max-min) + min);
            iban.append("INHO");
            long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
            iban.append(number);
            String finalIban = iban.toString();
            if(accountRepo.findAccountByIban(finalIban) == null ){
                return  finalIban;
            }
            else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Something went wrong generating your iban.");
            }
    }
}
