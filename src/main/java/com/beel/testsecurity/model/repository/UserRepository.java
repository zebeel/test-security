package com.beel.testsecurity.model.repository;

import com.beel.testsecurity.model.entity.MyUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Value("${db-username}")
    private String username;

    @Value("${db-password}")
    private String password;

    @Value("${db-info}")
    private String info;

    private Logger log = LoggerFactory.getLogger(UserRepository.class);

    public MyUser findUserByUsername(String username) {

        log.info("Login Username: " + username);

        if(username.equals(this.username))
            return new MyUser(this.username, this.password, this.info);

        return null;
    }

}
