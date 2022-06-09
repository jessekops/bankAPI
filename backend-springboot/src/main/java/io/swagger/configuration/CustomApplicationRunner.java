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

import java.util.ArrayList;
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

        List<UserType> userTypes = new ArrayList<>();
        userTypes.add(UserType.ROLE_EMPLOYEE);
        User Bank = new User();
        Bank.setActive(true);
        Bank.setUsername("InhollandBank");
        Bank.setPassword("welkom");
        Bank.setEmail("info@inhollandbank.nl");
        Bank.setPhone("+316 012345678");
        Bank.setDayLimit(0.00);
        Bank.setUserTypes(userTypes);

        double max = 1000000000000.00;
        Account bankAccount = new Account();
        bankAccount.setUser(Bank);
        bankAccount.setAbsLimit(0.00 - Double.MAX_VALUE);
        bankAccount.setBalance(max);
        bankAccount.setIban("NL01INHO0000000001");
        bankAccount.setAccountType(AccountType.CURRENT);
        bankAccount.setActive(true);


        userService.addUser(Bank);
        accountService.addAccount(bankAccount);

    }
}
