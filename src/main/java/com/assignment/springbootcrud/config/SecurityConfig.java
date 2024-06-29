package com.assignment.springbootcrud.config;

import com.assignment.springbootcrud.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
public class SecurityConfig {
//    @Autowired
//    public UserDetailsServiceImpl userDetailsService;


    @Bean(name = "userDetailsService")
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(request -> {

                    request
                            .requestMatchers("/users/**").permitAll()
//                            .requestMatchers(HttpMethod.POST, "/users/**").permitAll()
//                            .hasAnyRole("ADMIN", "SUPER_ADMIN")
//                            .requestMatchers(HttpMethod.POST, "/**")
//                            .hasAnyRole("USER")
//                            .anyRequest()
//                            .denyAll();
                            .anyRequest().permitAll();
                });
        return http.build();
    }
        // Define a password encoder bean if needed
        @Bean
        public BCryptPasswordEncoder passwordEncoder () {
            return new BCryptPasswordEncoder();
        }
    }
