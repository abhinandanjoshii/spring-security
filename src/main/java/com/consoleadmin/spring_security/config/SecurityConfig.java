package com.consoleadmin.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
//        http.formLogin(Customizer.withDefaults()); -> remove in case STATELESS
        http.httpBasic(Customizer.withDefaults());
        // configure -> no same session continuation
        http.sessionManagement(Customizer.withDefaults());

        return http.build();
    }

}
