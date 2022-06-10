package io.swagger.service;

import io.swagger.jwt.JwtTokenProvider;
import io.swagger.model.dto.TokenDTO;
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
import java.util.UUID;

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


    public TokenDTO login(String username, String password) {

        TokenDTO tokenDto = new TokenDTO();
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password)); // Check username and password via Spring Boot Security
            User user = userRepo.findByUsername(username);
            tokenDto.setToken(provider.createToken(username, user.getUserTypes()));
            tokenDto.setUserName(user.getUsername());
            tokenDto.setUserrole(user.getUserTypes());
            tokenDto.setUserId(user.getId());
        } catch (AuthenticationException authEx) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username and/or password");
        }

        return tokenDto;
    }

    public User addUser(User user) {

        user.setPassword(encoder.encode(user.getPassword()));

        return userRepo.save(user);
    }

    public User updateUser(User updatedUser) {

        updatedUser.setPassword(encoder.encode(updatedUser.getPassword()));

        return userRepo.save(updatedUser);
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public List<User> getAllWithoutAccount(){
        return userRepo.findAllWithoutAccount();
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public User findByPhone(String phone){
        return userRepo.findByPhone(phone);
    }

    public User findById(UUID id) {
        return userRepo.findUserById(id);
    }

    public void doesUserExist(User user){

        if(findByUsername(user.getUsername()) != null){
            throw new IllegalArgumentException("Username is already in use! Please try again");
        }

        if(findByEmail(user.getEmail()) != null){
            throw new IllegalArgumentException("Email is already in use! Please try again");
        }

        if(findByPhone(user.getPhone()) != null){
            throw new IllegalArgumentException("Phone number is already in use! Please try again");
        }

//        return findByUsername(user.getUsername()) != null && findByEmail(user.getEmail()) != null && findByPhone(user.getPhone()) != null;
    }
}