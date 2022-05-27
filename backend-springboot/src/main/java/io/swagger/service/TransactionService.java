package io.swagger.service;

import io.swagger.model.entity.Transaction;
import io.swagger.model.entity.User;
import io.swagger.repo.TransactionRepo;
import io.swagger.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    public List<Transaction> getAll(){
        return transactionRepo.findAll();
    }

    public Transaction findByTransactionFrom(String from) {
        return transactionRepo.findByTransactionFrom(from);
    }
}
