package io.swagger.configuration;

import io.swagger.model.entity.Account;
import io.swagger.model.entity.User;
import io.swagger.model.enumeration.AccountType;
import io.swagger.model.enumeration.UserType;
import io.swagger.service.AccountService;
import io.swagger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomApplicationRunner implements ApplicationRunner {

    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Add a standard User and Account for the bank itself to the DB when the application starts running

        User bank = new User();
        bank.setActive(true);
        bank.setUsername("InhollandBank");
        bank.setPassword("welkom");
        bank.setEmail("info@inhollandbank.nl");
        bank.setPhone("+316 012345678");
        bank.setDayLimit(0.00);
        bank.setUserTypes(List.of(UserType.ROLE_EMPLOYEE));

        double max = 1000000000000.00;
        Account bankAccount = new Account();
        bankAccount.setUser(bank);
        bankAccount.setAbsLimit(0.00 - Double.MAX_VALUE);
        bankAccount.setBalance(max);
        bankAccount.setIban("NL01INHO0000000001");
        bankAccount.setAccountType(AccountType.CURRENT);


        userService.addUser(bank);
        accountService.addAccount(bankAccount);

    }
}
