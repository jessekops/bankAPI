package io.swagger.service;

import io.swagger.model.entity.Account;
import io.swagger.model.entity.Transaction;
import io.swagger.model.entity.User;
import io.swagger.repo.AccountRepo;
import io.swagger.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.stereotype.Service;
import org.threeten.bp.LocalDate;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepo transactionRepo;
    TransactionService transactionService;
    TransactionValidatorService transactionValidatorService;
    AccountService accountService;
    AccountRepo accountRepo;
    UserService userService;
    Transaction transaction;
    Account account;
    User user;

    public Transaction createTransaction(Transaction trans) {
        if (transactionValidatorService.checkCurrentOrSavings(accountService.findAccountByIban(trans.getFrom().toString()), accountService.findAccountByIban(trans.getTo()))) {
//             one account is a savings account
//             Check if user is owner of account

            if (!transactionValidatorService.isUserOwner(account.getUser(), accountService.findAccountByIban(trans.getTo()))) {
                // user is not the owner of the account
                throw new IllegalArgumentException("Cannot transfer from or to savings account that does not belong to you.");
            } else {
//                 Check if from is not the same as to
                if (!transactionValidatorService.checkNotSameAccount(trans.getTo(), trans.getTo())) {
                    // from is same as to
                    throw new IllegalArgumentException("iban to cannot be the same as from.");
                } else {
//                     Check sufficient funds
                    if (!transactionValidatorService.checkSufficientFund(accountService.findAccountByIban(trans.getTo()), trans.getAmount())) {
                        // not enough balance
                        throw new IllegalArgumentException("Not enough balance");
                    } else {
                        if (!transactionValidatorService.checkAbsLimit(accountService.findAccountByIban(trans.getTo()), trans.getAmount())) {
                            // not enough balance
                            throw new IllegalArgumentException("Not enough balance (absolute limit)");
                        } else {
                            if (!transactionValidatorService.checkDayLimit(user.getUsername())) {
                                // spent too much today
                                throw new IllegalArgumentException("Exceeded day limit.");
                            } else {
                                // do transaction

                                // update from
                                updateFromBalance(trans);
                                // update to
                                updateToBalance(trans);
                            }
                        }
                    }
                }
            }
        } else { // Do normal transaction
            // Check if from is not the same as to
            if (!transactionValidatorService.checkNotSameAccount(trans.getTo(), trans.getTo())) {
                // from is same as to
                throw new IllegalArgumentException("iban to cannot be the same as from.");
            } else {
                // Check sufficient funds
                if (!transactionValidatorService.checkSufficientFund(accountService.findAccountByIban(trans.getTo()), trans.getAmount())) {
                    // not enough balance
                    throw new IllegalArgumentException("Not enough balance");
                } else {
                    if (!transactionValidatorService.checkAbsLimit(accountService.findAccountByIban(trans.getTo()), trans.getAmount())) {
                        // not enough balance
                        throw new IllegalArgumentException("Not enough balance (absolute limit)");
                    } else {
                        if (!transactionValidatorService.checkDayLimit(user.getUsername())) {
                            // spent too much today
                            throw new IllegalArgumentException("Exceeded day limit.");
                        } else {

                            // Do transaction
                            //
                            // update from
                            updateFromBalance(trans);
                            // update to
                            updateToBalance(trans);
                        }
                    }
                }
            }
        }
        return transactionRepo.save(trans);
    }

    // update from account
    private void updateFromBalance(Transaction trans) {
        Account account = accountRepo.findAccountByIban(trans.getFrom().toString());
        if (account != null) {
            account.setBalance((account.getBalance() - trans.getAmount()));
            accountRepo.save(account);
        }
    }

    // update to account
    private void updateToBalance(Transaction trans) {
        Account account = accountRepo.findAccountByIban(trans.getTo());
        if (account != null) {
            account.setBalance((account.getBalance() + trans.getAmount()));
            accountRepo.save(account);
        }
    }

    public Transaction findTransactionById(UUID id) {
        return transactionRepo.findTransactionById(id);
    }

    public void deleteTransaction(UUID id) {
        transactionRepo.delete(findTransactionById(id));
    }

    public Transaction updateTransaction(Transaction transaction) {
        return transactionRepo.save(transaction);
    }

    public List<Transaction> getTransactionsFromToday(LocalDate timeStamp) {
        return transactionRepo.findAllByTimestamp(timeStamp);
    }
}
