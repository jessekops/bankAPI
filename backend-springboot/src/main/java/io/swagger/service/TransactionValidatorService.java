package io.swagger.service;

import io.swagger.model.entity.Account;
import io.swagger.model.entity.Transaction;
import io.swagger.model.entity.User;
import io.swagger.model.enumeration.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class TransactionValidatorService {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;



    // Method to check if it is current or savings account

    public boolean checkCurrentOrSavings(Account accountFrom, Account accountTo) {

        if (!Objects.equals(accountFrom.getAccountType(), AccountType.SAVINGS) || !Objects.equals(accountTo.getAccountType(), AccountType.SAVINGS)) {
            return false;
        } else return true;
    }
    // Method to check if the user is the owner of the account

    public boolean isUserOwner(UUID userId, Account from, Account to) {

        if (!from.getUser().getId().equals(userId) || !to.getUser().getId().equals(userId)) {
            return false;
        } else return true;
    }

    // Method to check if the from account is not the same as to account

    public boolean checkNotSameAccount(String accountFrom, String accountTo) {
        if (accountFrom.equals(accountTo)) {
            return false;
        } else return true;
    }
//    // Method to check if there is sufficient funds
//
//    public boolean checkSufficientFund(Account accountFrom, double amount) {
//        double balance = accountFrom.getBalance();
//        if ((balance - amount) < 0) {
//            return false;
//        } else return true;
//    }

    // Method to check if there is sufficient funds (absolute limit)

    public boolean checkAbsLimit(Account accountFrom, double amount) {
        double balance = accountFrom.getBalance();
        double absLimit = accountFrom.getAbsLimit();

        if ((balance - amount) < absLimit) {
            return false;
        } else return true;
    }

    // Method to check if it does not override day limit

    public boolean checkDayLimit(User user, Transaction trans) {
        double dayLimit = user.getDayLimit();

        List<Transaction> transToday = transactionService.getTransactionsFromToday(LocalDate.now());
        double total = 0;
        for (Transaction transaction : transToday) {
            total += transaction.getAmount();
        }

        // Add the amount of the new transaction to the total
        total += trans.getAmount();
        if (total > dayLimit) {
            return false;
        } else return true;
    }

    public boolean checkActive(String ibanFrom, String ibanTo) {
        Account from = accountService.findAccountByIban(ibanFrom);
        Account to = accountService.findAccountByIban(ibanTo);
        if (from.getActive() && to.getActive()) {
            return true;
        } else return false;
    }
}
