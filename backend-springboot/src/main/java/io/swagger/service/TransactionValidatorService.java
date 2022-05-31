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
//    Account balance = accountService.findAccountByIban(account.getBalance());
//    Double amount = transaction.getAmount();
//    Double dayLimit = account.getUser().getDayLimit();
//    Double absLimit = account.getUser().getTransLimit();
//    User userFrom = account.getUser();
//    User userTo = account.getUser();
//
//    // Savings accounts cannot make a transaction to an account that does not belong to the same user
//
//    private boolean checkSameUser(User userFrom, User userTo) {
//        int valid = 0;
//
//        if (userFrom != userTo) {
//            valid++;
//        }
//
//        return valid == 1;
//    }
//
//    // Method to check if the from account is not the same as to account
//
//    private boolean checkNotSameAccount(Account accountFrom, Account accountTo) {
//        int valid = 0;
//
//        if (!accountFrom.equals(accountTo)) {
//            valid++;
//        }
//
//        return valid == 1;
//    }
//
//    // Method to check if there is sufficient funds
//
//    private boolean checkSufficientFund(Account accountFrom, Double amount, Double balance, Double dayLimit, Double absLimit) {
//        int valid = 0;
//
//        // Check if amount is smaller then balance
//        if (amount.compareTo(balance) < 0) {
//            valid++;
//        }
//
//        // Check if balance after the transaction is still bigger then the limit
//        if ((balance - amount).compareTo(absLimit) < 0) {
//            valid++;
//        }
//
//        // Check if daylimit gets proceeded
//        if (amount.compareTo(balance) < 0) {
//            valid++;
//        }
//
//        return valid == 3;
//    }
}
