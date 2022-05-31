package io.swagger.service;


import io.swagger.model.entity.Account;
import io.swagger.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AccountIbanGenService extends AccountService {
    @Autowired
    private AccountRepo accountRepo;


}
