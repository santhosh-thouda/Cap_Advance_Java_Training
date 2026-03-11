package com.capgemini.librarysystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

http
.csrf(csrf -> csrf.disable())

.authorizeHttpRequests(auth -> auth
.requestMatchers("/swagger-ui.html","/swagger-ui/**","/v3/api-docs/**").permitAll()
.anyRequest().authenticated()
)

.httpBasic();

return http.build();
}

@Bean
public UserDetailsService userDetailsService() {

UserDetails admin =
User.withUsername("admin")
.password(passwordEncoder().encode("admin123"))
.roles("ADMIN")
.build();

return new InMemoryUserDetailsManager(admin);
}

@Bean
public PasswordEncoder passwordEncoder(){
return new BCryptPasswordEncoder();
}

}