package io.swagger.service;

import io.swagger.model.entity.Transaction;
import io.swagger.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;


    public Transaction createTransaction(Transaction trans) {

        // Savings accounts cannot make a transaction to an account that does not belong to the same user

        // Check sufficient funds

        // Check day limit and balance limit

        return transactionRepo.save(trans);
    }


    public List<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
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
}
