package com.socialnetworkingapp.nxtapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialnetworkingapp.nxtapp.model.Comment;
import com.socialnetworkingapp.nxtapp.model.Post;
import com.socialnetworkingapp.nxtapp.repository.PostRepository;


@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post createPost(final Post post) {
        return postRepository.save(post);
    }

    public Post addComment(final String postId, final Comment comment) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        post.getComments().add(comment);
        return postRepository.save(post);
    }

    public void likePost(final String postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setLikeCount(post.getLikeCount()+1);
        postRepository.save(post);
    }
}
