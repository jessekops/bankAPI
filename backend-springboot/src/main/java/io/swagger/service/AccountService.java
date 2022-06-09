package io.swagger.service;

import io.swagger.model.entity.Account;
import io.swagger.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private AccountIbanGenService accountIbanGenService;

    //account validation
    public Account addAccount(Account a) {

        if (a.getBalance() == null || a.getUser() == null || a.getAccountType() == null || a.getAbsLimit() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please fill in all fields.");
        } else if (!accountIbanGenService.pinCheck(a.getPinCode())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pin code has to be 4 digits long and of type Integer.");
        } else {
            String iban = accountIbanGenService.generateIban();
            if (a.getActive() == null) {
                a.setActive(true);
            }
            if (iban.length() != 0) {
                if (a.getIban() == null) {
                    a.setIban(iban);
                }
                return accountRepo.save(a);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Something went wrong generating your iban.");
            }
        }
    }


    public List<Account> findAccountsByUserId(UUID userId) {
        if (!accountRepo.findAccountsByUserId(userId).isEmpty()) {
            return accountRepo.findAccountsByUserId(userId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Account updateAccount(Account updatedAccount) {
        return accountRepo.save(updatedAccount);
    }

    public Account findAccountByIban(String iban) {
        //find account by iban logic
        if (accountRepo.findAccountByIban(iban) != null) {
            return accountRepo.findAccountByIban(iban);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    public List<Account> getAll() {
        return accountRepo.findAll();
    }
}
