package com.socialnetworkingapp.nxtapp.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "posts")
public class Post {

@Id
private String id;
private String userId;
private String content;
private String imageUrl;
private int likeCount;
private List<Comment> comments;
private Date timestamp;
    
}
