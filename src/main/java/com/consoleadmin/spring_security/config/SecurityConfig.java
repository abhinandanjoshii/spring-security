package com.consoleadmin.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //disabling csrf
        http.csrf(customizer -> customizer.disable());
        //enable usernmae pass
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        //form login
//        http.formLogin(Customizer.withDefaults()); // -> remove in case STATELESS
        http.httpBasic(Customizer.withDefaults());
        // configure -> no same session continuation
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();

    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user= User
                .withDefaultPasswordEncoder()
                .username("consoleadmin")
                .password("123")
                .roles("USER")
                .build();

        UserDetails  admin=User
                .withDefaultPasswordEncoder()
                .username("admin")
                .password("admin@789")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user,admin);
    }

}
