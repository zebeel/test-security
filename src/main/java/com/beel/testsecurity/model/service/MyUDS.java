package com.beel.testsecurity.model.service;

import com.beel.testsecurity.model.entity.MyUser;
import com.beel.testsecurity.model.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * My User Detail Service
 */
@Service
public class MyUDS implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    private Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String username) {
        MyUser user = userRepo.findUserByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException(username);
        }

        log.info("Username: " + user.getUsername() + ", Password: " + user.getPassword());

        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

}
