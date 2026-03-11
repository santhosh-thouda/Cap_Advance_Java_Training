package com.capgemini.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.sms.entity.AppUser;
import com.capgemini.sms.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

@Autowired
private UserRepository repository;

@Autowired
private PasswordEncoder encoder;

@Override
public AppUser createUser(AppUser user){

user.setPassword(encoder.encode(user.getPassword()));

return repository.save(user);

}

}