package com.consoleadmin.spring_security.service;

import com.consoleadmin.spring_security.dao.UserRepo;
import com.consoleadmin.spring_security.model.MainUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public MainUser saveUser(MainUser user) {
        return userRepo.save(user);
    }

}
