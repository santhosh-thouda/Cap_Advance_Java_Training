package com.capgemini.sms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

http
.csrf(csrf -> csrf.disable())
.cors(cors -> {})

.authorizeHttpRequests(auth -> auth

.requestMatchers("/users").permitAll()   // important

.requestMatchers("/students/**").hasAnyRole("ADMIN","USER")

.requestMatchers("/actuator/**").permitAll()

.anyRequest().authenticated()

)

.httpBasic();

return http.build();
}

@Bean
public PasswordEncoder passwordEncoder() {
return new BCryptPasswordEncoder();
}

}