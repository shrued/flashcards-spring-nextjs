package com.shrued.snapstudy.snapstudybackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/api/flashcards/**").authenticated() // Secure all flashcard endpoints
                .anyRequest().permitAll() // Allow all other requests
            )
            .httpBasic(); // Enable HTTP Basic authentication (for now)
        return http.build();
    }
}
