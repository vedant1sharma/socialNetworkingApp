package com.socialnetworkingapp.nxtapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetworkingapp.nxtapp.model.User;
import com.socialnetworkingapp.nxtapp.repository.UserRepository;



@RestController
public class UserController {
    
    @Autowired
    private UserRepository userRepo;

    @PostMapping("/user/register")
    public User registerUser(@RequestBody User user) {
       return userRepo.save(user);
    }
    
}
