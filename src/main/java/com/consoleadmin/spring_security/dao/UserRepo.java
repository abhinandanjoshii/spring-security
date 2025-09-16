package com.consoleadmin.spring_security.dao;

import com.consoleadmin.spring_security.model.MainUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<MainUser, Integer> {
    MainUser findByUsername(String username);
}
