package io.swagger.service;

import io.swagger.model.entity.Account;
import io.swagger.model.entity.Transaction;
import io.swagger.model.entity.User;
import io.swagger.model.enumeration.AccountType;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionValidatorService {

//    private TransactionService transactionService;
//    private AccountService accountService;
//    private UserService userService;
//    private Transaction transaction;
//    private Account account;
//    private User user;
//
//
//    // Method to check if it is current or savings account
//
//    public boolean checkCurrentOrSavings(String ibanFrom, String ibanTo) {
//        Account accountTo = accountService.findAccountByIban(ibanTo);
//        Account accountFrom = accountService.findAccountByIban(ibanFrom);
//
//        if (accountFrom.getAccountType() != AccountType.SAVINGS || accountTo.getAccountType() != AccountType.SAVINGS) {
//            return false;
//        } else return true;
//    }
//    // Method to check if the user is the owner of the account
//
//    public boolean isUserOwner(User user, String iban) {
//        Account account = accountService.findAccountByIban(iban);
//
//        if (account.getUser() != user) {
//            return false;
//        } else return true;
//    }
//
//    // Method to check if the from account is not the same as to account
//
//    public boolean checkNotSameAccount(String accountFrom, String accountTo) {
//        if (accountFrom.equals(accountTo)) {
//            return false;
//        } else return true;
//    }
//    // Method to check if there is sufficient funds
//
//    public boolean checkSufficientFund(String iban, double amount) {
//        Account account = accountService.findAccountByIban(iban);
//        double balance = account.getBalance();
//        if (balance - amount < 0) {
//            return false;
//        } else return true;
//    }
//
//    public boolean checkAbsLimit(String iban, double amount) {
//        Account account = accountService.findAccountByIban(iban);
//        double balance = account.getBalance();
//        double absLimit = account.getAbsLimit();
//
//        if (balance - amount < absLimit) {
//            return false;
//        } else return true;
//    }
//
//    public boolean checkDayLimit(String iban, double amount) {
//        Account account = accountService.findAccountByIban(iban);
//        User user = account.getUser();
//        double dayLimit = user.getDayLimit();
//
//        List<Transaction> transToday = getTotdayTransactions(transaction);
//        float total = 0;
//        for (Transaction transaction : transToday) {
//            total += amount;
//        }
//        if (total > dayLimit) {
//            return false;
//        } else return true;
//    }
//
//    private List<Transaction> getTotdayTransactions(Transaction transaction) {
//        List<Transaction> transactions = findbyfrom
//
//        OffsetDateTime localTime = OffsetDateTime.now();
//        List<Transaction> transToday = new ArrayList<>();
//        for (Transaction trans : transactions) {
//            if (trans.getTimestamp().getYear() == localTime.getYear()
//                && trans.getTimestamp().getMonth() == localTime.getMonth()
//                    && trans.getTimestamp().getDayOfMonth() == localTime.getDayOfMonth()) {
//                transToday.add(trans);
//            }
//        }
//    }
}
