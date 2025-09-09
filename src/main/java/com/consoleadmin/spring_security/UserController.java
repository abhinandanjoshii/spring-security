package com.consoleadmin.spring_security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    List<User> userDetails = new ArrayList<>(List.of(
        new User(1,"Abhi","Java"),
        new User(2,"Harsh","CPP"),
        new User(1,"Shorya","Python")
    ));

    // Add it at Header -> X-CRRF-TOKEN
    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("users")
    public List<User> getUsers(){
        return userDetails;
    }

    @PostMapping("users")
    public void addUsers(@RequestBody User user){
        userDetails.add(user);
    }

}
