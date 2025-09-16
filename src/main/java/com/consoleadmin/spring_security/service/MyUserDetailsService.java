package com.consoleadmin.spring_security.service;

import com.consoleadmin.spring_security.dao.UserRepo;
import com.consoleadmin.spring_security.model.MainUser;
import com.consoleadmin.spring_security.model.UserPrinicipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MainUser user = repo.findByUsername(username);
        if (user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException(username);
        }

        return new UserPrinicipal(user);
    }
}
