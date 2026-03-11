package com.capgemini.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.capgemini.sms.entity.AppUser;
import com.capgemini.sms.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

@Autowired
private UserService service;

@PostMapping
public AppUser createUser(@RequestBody AppUser user){
return service.createUser(user);
}

}