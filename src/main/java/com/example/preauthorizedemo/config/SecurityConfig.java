package com.example.preauthorizedemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableMethodSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        var service = new InMemoryUserDetailsManager();
        var u1 = User.withUsername("mary")
                .password("12345")
                .authorities("read")
                .build();
        var u2 = User.withUsername("john")
                .password("12345")
                .authorities("write")
                .build();
        service.createUser(u1);
        service.createUser(u2);
        return service;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
