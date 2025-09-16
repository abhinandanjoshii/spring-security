package com.consoleadmin.spring_security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // CSRF : when someone steals my session from cookie : Spring Security Auto Handles
    // Cross Site Request Forgery
    // Spring Auto Creates CSRF for all POST, PUT, DELETE not on GET
    // CSRF makes request Stateless to Stateful , carrying same Session forward.
    @GetMapping("hello")
    public String greet(HttpServletRequest request) {
        return "Hello World " + request.getSession().getId();
    }

    @GetMapping("about")
    public String about(HttpServletRequest request) {
        return "Session Id : " + request.getSession().getId();
    }

}
