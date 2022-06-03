package io.swagger.service;

import io.swagger.model.entity.Account;
import io.swagger.model.entity.Transaction;
import io.swagger.model.entity.User;
import io.swagger.model.enumeration.AccountType;

public class TransactionValidatorService {

    private TransactionService transactionService;
    private AccountService accountService;
    private UserService userService;
    private Transaction transaction;
    private Account account;
    private User user;


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
//
//        if ((account.getBalance().subtract(amount)).compareTo(account.getAbsLimit()) < 0) {
//            return false;
//        } else return true;
//    }
}
