package com.socialnetworkingapp.nxtapp.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private String bio;
    private List<String> followers;
    private List<String> following;
    private List<String> blockedUsers;
    private boolean isActive;


}