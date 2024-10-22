package com.socialnetworkingapp.nxtapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.socialnetworkingapp.nxtapp.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByUserId(final String userId);
}
