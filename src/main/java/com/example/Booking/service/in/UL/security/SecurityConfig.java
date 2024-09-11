package com.example.Booking.service.in.UL.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Настройка аутентификации
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/registration", "/login", "/","/reservations/**").permitAll() // Доступ разрешен всем
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Доступ только для ADMIN
                        .anyRequest().authenticated() // Все остальные запросы требуют аутентификации
                )
                .formLogin((form) -> form
                        .loginPage("/hello") // Указание страницы для входа
                        .defaultSuccessUrl("/", true) // Перенаправление после успешного входа
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutSuccessUrl("/") // Перенаправление после выхода
                        .permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}

