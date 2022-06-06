package io.swagger.service;

import io.swagger.model.entity.Account;
import io.swagger.model.entity.Transaction;
import io.swagger.model.entity.User;
import io.swagger.repo.AccountRepo;
import io.swagger.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

//    @Autowired
//    private TransactionRepo transactionRepo;
//    private TransactionService transactionService;
//    private TransactionValidatorService transactionValidatorService;
//    private AccountService accountService;
//    private AccountRepo accountRepo;
//    private UserService userService;
//    private Transaction transaction;
//    private Account account;
//    private User user;
//
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
//
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
//                    if (!transactionValidatorService.checkSufficientFund(accountFrom, amount)) {
//                        // not enough balance
//                    } else {
//                        if (!transactionValidatorService.checkAbsLimit(accountFrom, amount)) {
//                            // not enough balance
//                        } else {
//                            if (!transactionValidatorService.checkDayLimit(accountFrom, amount)) {
//                                // spent too much today
//                            } else {
//                                // do transaction
//
//                                // update from
//                                updateFromBalance(transaction);
//                                // update to
//                                updateToBalance(transaction);
//                            }
//                        }
//                    }
//                }
//            }
//        } else { // Do normal transaction
//            // Check if from is not the same as to
//            if (!transactionValidatorService.checkNotSameAccount(accountFrom, accountTo)) {
//                // from is same as to
//            } else {
//                // Check sufficient funds
//                if (!transactionValidatorService.checkSufficientFund(accountFrom, amount)) {
//                    // not enough balance
//                } else {
//                    if (!transactionValidatorService.checkAbsLimit(accountFrom, amount)) {
//                        // not enough balance
//                    } else {
//                        if (!transactionValidatorService.checkDayLimit(accountFrom, amount)) {
//                            // spent too much today
//                        } else {
//
//                            // Do transaction
//
//                            // update from
//                            updateFromBalance(transaction);
//                            // update to
//                            updateToBalance(transaction);
//                        }
//                    }
//                }
//
//            }
//        }
//        return transactionRepo.save(trans);
//    }
//    // update from account
//    private void updateFromBalance(Transaction transaction) {
//        Account account = accountRepo.findAccountByIban(transaction.getFrom());
//        if (account != null) {
//            account.setBalance((account.getBalance() - transaction.getAmount()));
//            accountRepo.save(account);
//        }
//    }
//
//    // update to account
//    private void updateToBalance(Transaction transaction) {
//        Account account = accountRepo.findAccountByIban(transaction.getTo());
//        if (account != null) {
//            account.setBalance((account.getBalance() - transaction.getAmount()));
//            accountRepo.save(account);
//        }
//    }
//
//    public Transaction findTransactionById(UUID id) {
//        return transactionRepo.findTransactionById(id);
//    }
//
//    public void deleteTransaction(UUID id) {
//        transactionRepo.delete(findTransactionById(id));
//    }
//
//    public Transaction updateTransaction(Transaction transaction) {
//        return transactionRepo.save(transaction);
//    }
}
