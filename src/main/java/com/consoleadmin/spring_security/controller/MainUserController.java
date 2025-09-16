package com.consoleadmin.spring_security.controller;

import com.consoleadmin.spring_security.model.MainUser;
import com.consoleadmin.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainUserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public MainUser register(@RequestBody MainUser user) {
        return userService.saveUser(user);
    }

}
