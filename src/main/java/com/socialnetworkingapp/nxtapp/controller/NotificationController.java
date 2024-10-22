package com.socialnetworkingapp.nxtapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetworkingapp.nxtapp.model.Notification;
import com.socialnetworkingapp.nxtapp.service.NotificationService;



@RestController
@RequestMapping("/notifications")
public class NotificationController {
    
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{recipientId}")
    public ResponseEntity<List<Notification>> getMethodName(@PathVariable final String recipientId) {
        return ResponseEntity.ok(notificationService.getUserNotifications(recipientId));
    }

    @PostMapping("/read/{notificationId}")
    public ResponseEntity<Void> markNotification(@PathVariable final String notificationId) {
        notificationService.markNotification(notificationId);
        return ResponseEntity.ok().build();
    }
    
    
}
