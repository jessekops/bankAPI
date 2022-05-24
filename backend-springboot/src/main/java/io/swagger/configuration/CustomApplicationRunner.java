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

//        //Add test user to DB when the application starts running
//        User testUser = new User();
//        //Add user info here
//
//        userService.addUser(testUser);

    }
}
