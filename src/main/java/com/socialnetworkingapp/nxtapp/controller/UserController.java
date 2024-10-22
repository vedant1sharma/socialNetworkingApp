package com.socialnetworkingapp.nxtapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetworkingapp.nxtapp.model.User;
import com.socialnetworkingapp.nxtapp.repository.UserRepository;
import com.socialnetworkingapp.nxtapp.service.UserService;



@RestController
public class UserController {
    
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public User registerUser(@RequestBody User user) {
       return userRepo.save(user);
    }

    @PostMapping("/{userId}/block/{blockedUserId}")
    public ResponseEntity<User> blockUser(@PathVariable final String userId, @PathVariable final String blockedUserId) {
        return ResponseEntity.ok(userService.blockUser(userId, blockedUserId));
    }

   @PostMapping("/{userId}/unblock/{blockedUserId}")
    public ResponseEntity<User> unblockUser(@PathVariable final String userId, @PathVariable final String blockedUserId) {
        return ResponseEntity.ok(userService.unblockUser(userId, blockedUserId));
    }
    
}
