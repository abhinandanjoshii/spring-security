package com.consoleadmin.spring_security.controller;

import com.consoleadmin.spring_security.model.MainUser;
import com.consoleadmin.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainUserController {

    @Autowired
    private UserService userService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping("register")
    public MainUser register(@RequestBody MainUser user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userService.saveUser(user);
    }

}
