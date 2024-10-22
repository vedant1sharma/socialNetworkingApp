package com.socialnetworkingapp.nxtapp.service;

import com.socialnetworkingapp.nxtapp.model.User;
import com.socialnetworkingapp.nxtapp.repository.UserRepository;

import lombok.val;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(final User user) {
        return userRepository.save(user);
    }

    public User followUser(final String userId, final String followerId) {
        val user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Couldn't find user"));
        user.getFollowers().add(followerId);
        return userRepository.save(user);
    }

    
}
