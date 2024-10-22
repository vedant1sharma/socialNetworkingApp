package com.socialnetworkingapp.nxtapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetworkingapp.nxtapp.model.Comment;
import com.socialnetworkingapp.nxtapp.model.Post;
import com.socialnetworkingapp.nxtapp.service.PostService;


@RestController
@RequestMapping("/posts")
public class PostController {
    
    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.createPost(post));
    }

    @PostMapping("/{postId}/comment")
    public ResponseEntity<Post> addComment(@PathVariable String postId, @RequestBody Comment comment) {
        return ResponseEntity.ok(postService.addComment(postId, comment));
    }
    
    @PostMapping("/{postId}/like")
    public ResponseEntity<Void> likePost(@RequestBody String postId) {
        postService.likePost(postId);
        return ResponseEntity.ok().build();
    }
    
}
