package io.swagger.service;

import io.swagger.model.entity.Transaction;
import io.swagger.model.entity.User;
import io.swagger.repo.TransactionRepo;
import io.swagger.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    // Method to check if the transaction is valid

//    private boolean validTransaction(String from, String to) {
//        int valid = 0;
//
//        if (!from.equals(to)) {
//            valid++;
//        }
//
//        //check if both accounts are current accounts
//
//        return valid == 2;
//    }

    // Method to check if the amount will not be over day limit
//    public boolean underDayLimit(Double amount, User performerUser) {
//
//    }

    public Transaction createTransaction(Transaction trans){

        // Check to and from iBan if they exist and are not closed.

        // Savings accounts cannot make a transaction to an account that does not belong to the same user

        // Users cannot do transactions with the savings account to other users

        // Check sufficient funds

        // Check day limit and balance limit

        return transactionRepo.save(trans);
    }



    public List<Transaction> getAllTransactions(){
        if (transactionRepo.findAll().size() == 0) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "No transactions"); // Throw exception when 0 transactions
        }
        return transactionRepo.findAll();
    }

    public Transaction findTransactionByFrom(String from) {
        if (transactionRepo.findTransactionByFrom(from) == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "No transactions");
        }
        return transactionRepo.findTransactionByFrom(from);
    }

    public Transaction findTransactionByTo(String to) {
        if (transactionRepo.findTransactionByTo(to) == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "No transactions");
        }
        return transactionRepo.findTransactionByTo(to);
    }
    public Transaction findTransactionById(UUID id){
        if (transactionRepo.findTransactionById(id) == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "No transactions");
        }
        return transactionRepo.findTransactionById(id);
    }

    public void deleteTransactionById(UUID id){
        transactionRepo.delete(findTransactionById(id));
    }

}
