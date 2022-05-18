package io.swagger.service;

import io.swagger.model.entity.User;
import io.swagger.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private UserRepo userRepo;

    //Just an example, think about your code!
    public List<User> getAll(){
        return userRepo.findAll();
    }

}