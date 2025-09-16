package com.consoleadmin.spring_security.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class MainUser {
    @Id
    private int id;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
}
