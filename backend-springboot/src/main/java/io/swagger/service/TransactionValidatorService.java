package io.swagger.service;

import io.swagger.model.entity.Account;
import io.swagger.model.entity.Transaction;
import io.swagger.model.entity.User;

public class TransactionValidatorService {

    private TransactionService transactionService;
    private AccountService accountService;
    private UserService userService;
    private Transaction transaction;
    private Account account;
    private User user;

//    Account accountFrom = accountService.findAccountByIban(transaction.getFrom());
//    Account accountTo = accountService.findAccountByIban(transaction.getTo());

    //    Account balance = account.getBalance(accountService.findAccountByIban());
//    Double amount = transaction.getAmount();
//    Double dayLimit = account.getUser().getDayLimit();
//    Double absLimit = account.getUser().getTransLimit();
//
//    User userFrom = account.getUser();
//    User userTo = account.getUser();
//
//    // Method to check if the user is the owner of the account
//
//    private boolean isUserOwner(User user, String iban) {
//        Account account = accountService.findAccountByIban(iban);
//
//        if (account.getUser() != user) {
//            return false;
//        } else return true;
//    }
//
//    // Method to check if the from account is not the same as to account
//
//    private boolean checkNotSameAccount(Account accountFrom, Account accountTo) {
//
//        if (accountFrom.equals(accountTo)) {
//            return false;
//        } else return true;
//    }
//
//    // Method to check if there is sufficient funds
//
//    private boolean checkSufficientFund(String iban, double amount) {
//        Account account = accountService.findAccountByIban(iban);
//
//        if ((account.getBalance().subtract(amount)).compareTo(account.getAbsLimit()) < 0) {
//            return false;
//        } else return true;
//    }
}
