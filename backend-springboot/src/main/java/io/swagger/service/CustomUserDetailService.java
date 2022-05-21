package io.swagger.service;

import io.swagger.model.entity.User;
import io.swagger.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User '" + username + "' not found in DB");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.getPassword())
                .authorities(user.getUserTypes())
                .accountExpired(false)
                .accountLocked(false)
                .disabled(false)
                .credentialsExpired(false)
                .build();
    }
}
