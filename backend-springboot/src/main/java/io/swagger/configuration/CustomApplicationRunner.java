package io.swagger.configuration;

import io.swagger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomApplicationRunner implements ApplicationRunner {

    @Autowired
    UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        //Add a test Customer & Employee to the DB when the application starts running
//        User testCustomer = new User();
//        User testEmployee = new User();
//        //Add user info here
//        testCustomer.setUsername("customer");
//        testCustomer.setPassword("customer");
//        testCustomer.s
//
//
//        userService.addUser(testCustomer);
//        userService.addUser(testCustomer);

    }
}
