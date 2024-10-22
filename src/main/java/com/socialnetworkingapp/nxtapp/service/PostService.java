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

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    public Post createPost(final Post post) {
        return postRepository.save(post);
    }

    public Post addComment(final String postId, final Comment comment) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));

        // Check if the commenter is blocked by post owner
        if(userService.isUserBlocked(post.getUserId(), comment.getUserId())) {
            throw new RuntimeException("You are blocked from commenting on this post!");
        }

        post.getComments().add(comment);
        postRepository.save(post);

        // To trigger notification to post owner
        notificationService.createNotification(comment.getUserId(), post.getUserId(), "Someone added a comment to your post.");
        
        return post;
    }

    public void likePost(final String postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setLikeCount(post.getLikeCount()+1);
        postRepository.save(post);
    }
}
