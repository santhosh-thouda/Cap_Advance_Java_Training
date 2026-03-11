package com.capgemini.sms.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.capgemini.sms.entity.AppUser;
import com.capgemini.sms.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

@Autowired
private UserRepository repository;

@Override
public UserDetails loadUserByUsername(String username)
throws UsernameNotFoundException{

AppUser user = repository.findByUsername(username)
.orElseThrow(() ->
new UsernameNotFoundException("User not found"));

return new User(
user.getUsername(),
user.getPassword(),
Collections.singleton(
new org.springframework.security.core.authority.SimpleGrantedAuthority(user.getRole())
)
);

}

}