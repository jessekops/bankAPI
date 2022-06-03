package io.swagger.service;

import io.swagger.model.entity.Account;
import io.swagger.model.entity.Transaction;
import io.swagger.model.entity.User;
import io.swagger.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;
    private TransactionService transactionService;
    private TransactionValidatorService transactionValidatorService;
    private AccountService accountService;
    private UserService userService;
    private Transaction transaction;
    private Account account;
    private User user;

//    String accountFrom = accountService.findAccountByIban(transaction.getFrom());
//    String accountTo = accountService.findAccountByIban(transaction.getTo());
//
//    Double balance = account.getBalance();
//    Double amount = transaction.getAmount();
//    Double dayLimit = account.getUser().getDayLimit();
//    Double absLimit = account.getUser().getTransLimit();
//
//    User userFrom = account.getUser();
//    User userTo = account.getUser();

//    public Transaction createTransaction(Transaction trans) {
//        if (transactionValidatorService.checkCurrentOrSavings(accountFrom, accountTo)) {
//            // one account is a savings account
//            // Check if user is owner of account
//            if (!transactionValidatorService.isUserOwner(userFrom, accountFrom)) {
//                // user is not the owner of the account
//            } else {
//                // Check if from is not the same as to
//                if (!transactionValidatorService.checkNotSameAccount(accountFrom, accountTo)) {
//                    // from is same as to
//                } else {
//                    // Check sufficient funds
//                }
//                // do transaction
//
//                // update from
//
//                // update to
//            }
//        } else { // Do normal transaction
//            // Check sufficient funds
//
//            // Check day limit
//
//            // Check abs limit
//
//            // Do transaction
//
//            // update from
//
//            // update to
//        }

//        return transactionRepo.save(trans);
//    }


    public Transaction findTransactionById(UUID id) {
        return transactionRepo.findTransactionById(id);
    }

    public void deleteTransaction(UUID id) {
        transactionRepo.delete(findTransactionById(id));
    }

    public Transaction updateTransaction(Transaction transaction) {
        return transactionRepo.save(transaction);
    }
}
