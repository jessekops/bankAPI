package io.swagger.service;

import io.swagger.jwt.JwtTokenProvider;
import io.swagger.model.entity.User;
import io.swagger.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    JwtTokenProvider provider;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    PasswordEncoder encoder;


    public String login(String username, String password) {

        String token = "";

        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password)); // Check username and password via Spring Boot Security
            User user = userRepo.findByUsername(username);
            token = provider.createToken(username, user.getUserTypes()); //user.getUserTypes() //List.of(user.getUserType()
        } catch (AuthenticationException authEx) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username and/or password");
        }

        return token;
    }

    public User addUser(User user) {

        user.setPassword(encoder.encode(user.getPassword()));

        return userRepo.save(user);
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public User updateUser(User updatedUser) {
        return userRepo.save(updatedUser);
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }
}