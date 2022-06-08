package io.swagger.service;

import io.swagger.model.entity.Account;
import io.swagger.model.entity.Transaction;
import io.swagger.model.entity.User;
import io.swagger.model.enumeration.AccountType;
import org.threeten.bp.LocalDate;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TransactionValidatorService {

    private TransactionService transactionService;
    private AccountService accountService;
    private UserService userService;
    private Transaction transaction;
    private Account account;
    private User user;


    // Method to check if it is current or savings account

    public boolean checkCurrentOrSavings(Account accountTo, Account accountFrom) {

        if (!Objects.equals(accountFrom.getAccountType(), AccountType.SAVINGS) || !Objects.equals(accountTo.getAccountType(), AccountType.SAVINGS)) {
            return false;
        } else return true;
    }
    // Method to check if the user is the owner of the account

    public boolean isUserOwner(User user, Account account) {

        if (account.getUser() != user) {
            return false;
        } else return true;
    }

    // Method to check if the from account is not the same as to account

    public boolean checkNotSameAccount(String accountFrom, String accountTo) {
        if (accountFrom.equals(accountTo)) {
            return false;
        } else return true;
    }
    // Method to check if there is sufficient funds

    public boolean checkSufficientFund(Account iban, double amount) {
        double balance = iban.getBalance();
        if (balance - amount < 0) {
            return false;
        } else return true;
    }

    // Method to check if there is sufficient funds (absolute limit)

    public boolean checkAbsLimit(Account iban, double amount) {
        double balance = iban.getBalance();
        double absLimit = iban.getAbsLimit();//

        if (balance - amount < absLimit) {
            return false;
        } else return true;
    }

    // Method to check if it does not override day limit

    public boolean checkDayLimit(String userName) {
        User user = userService.findByUsername(userName);
        double dayLimit = user.getDayLimit();

        List<Transaction> transToday = transactionService.getTransactionsFromToday(LocalDate.now());
        double total = 0;
        for (Transaction transaction : transToday) {
            total += transaction.getAmount();
        }
        if (total > dayLimit) {
            return false;
        } else return true;
    }
}
