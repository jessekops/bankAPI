package io.swagger.service;

import io.swagger.model.entity.Account;
import io.swagger.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private AccountIbanService accountIbanService;


    //account validation
    public Account addAccount(Account a) {
        //check if all fields have been filled
        if (!this.allFieldsFilled(a)) {
            throw new IllegalArgumentException("Please fill in all the required fields.");
        }
        //check if pincode is of type INT and 4 digits long
        if (!this.pinCheck(a.getPinCode())) {
            throw new IllegalArgumentException("Pin code has to be 4 digits long and of type Integer.");
        }
        //check if there is an iban already assigned to the account and if the generated iban is valid to set the generated iban
        if (!accountIbanService.isIbanPresent(a.getIban())) {
            String iban = accountIbanService.generateIban();
            a.setIban(iban);
        }
        return Optional.of(accountRepo.save(a)).orElseThrow(
                () -> new IllegalArgumentException("Something went wrong trying to add your account."));
    }

    //find an accountlist by using the userid/owner id
    public List<Account> findAccountsByUserId(UUID userId) {
        List<Account> accountList = accountRepo.findAccountsByUserId(userId);
        if (accountList.isEmpty()) {
            throw new IllegalArgumentException("Something went wrong trying to find accounts with userid: " + userId);
        }
        return accountList;
    }

    //update an account with newly inserted account
    public Account updateAccount(Account a) {
        return Optional.of(accountRepo.save(a)).orElseThrow(
                () -> new IllegalArgumentException("Something went wrong trying to update your account."));
    }

    public Account findAccountByIban(String iban) {
//        return accountRepo.findAccountByIban(iban).orElseThrow(() -> new IllegalArgumentException("Something went wrong trying to find account with iban: " + iban));
        return accountRepo.findAccountByIban(iban).orElse(null);
    }

    public List<Account> getAll() {
        //this deletes the bank account from the list
        List<Account> accountList = accountRepo.findAll();
        accountList.removeIf(account -> account.getIban().equals("NL01INHO0000000001"));
        return accountList;
    }

    //pincode check for integer
    private boolean pinCheck(Integer pin) {
        return String.valueOf(pin).length() == 4;
    }

    //check if all required fields are filled
    private boolean allFieldsFilled(Account a) {
        return a.getBalance() != null && a.getAccountType() != null && a.getUser() != null;
    }
}
