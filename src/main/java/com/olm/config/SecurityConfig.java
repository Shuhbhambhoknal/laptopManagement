package com.olm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.olm.services.UserService;

@Configuration
public class SecurityConfig {

    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            // Replace antMatchers with requestMatchers
            .requestMatchers("/admin/**").hasRole("ADMIN") // Example path with ADMIN role
            .requestMatchers("/user/**").hasRole("USER")  // Example path with USER role
            .anyRequest().authenticated() // All other requests require authentication
            .and()
            .formLogin()
            .defaultSuccessUrl("/home", true) // Redirect after successful login
            .permitAll()
            .and()
            .logout()
            .permitAll();
        
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
            http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService)
            .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

}
