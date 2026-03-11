package com.capgemini.eventsystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

http
.csrf(csrf -> csrf.disable())
.authorizeHttpRequests(auth -> auth
		.requestMatchers(HttpMethod.GET,"/events/**")
		.hasAnyRole("USER","ADMIN")

		.requestMatchers(HttpMethod.POST,"/events/**")
		.hasRole("ADMIN")

		.requestMatchers(HttpMethod.PUT,"/events/**")
		.hasRole("ADMIN")

		.requestMatchers(HttpMethod.DELETE,"/events/**")
		.hasRole("ADMIN")

		.requestMatchers(HttpMethod.PATCH,"/events/**")
		.hasRole("ADMIN")
		
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

UserDetails user =
User.withUsername("user")
.password(passwordEncoder().encode("user123"))
.roles("USER")
.build();

return new InMemoryUserDetailsManager(admin,user);
}

@Bean
public PasswordEncoder passwordEncoder() {
return new BCryptPasswordEncoder();
}

}