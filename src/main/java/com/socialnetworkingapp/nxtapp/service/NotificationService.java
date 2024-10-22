package com.socialnetworkingapp.nxtapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialnetworkingapp.nxtapp.model.Notification;
import com.socialnetworkingapp.nxtapp.repository.NotificationRepository;

@Service
public class NotificationService {
    
    @Autowired
    private NotificationRepository notificationRepository;

    public Notification createNotification(final String senderId, final String recipientId, final String message) {
        Notification notification = new Notification();
        notification.setSenderId(senderId);
        notification.setRecipientId(recipientId);
        notification.setMessage(message);
        notification.setTimestamp(new Date());
        notification.setRead(false);
        return notificationRepository.save(notification);
    }

    public List<Notification> getUserNotifications(final String recipientId) {
        return notificationRepository.findByRecipientId(recipientId);
    }

    public void markNotification(String notificationId) {
        Notification notification = notificationRepository.findById(notificationId).orElseThrow(
            () -> new RuntimeException("Notification not found"));
        notification.setRead(true);
        notificationRepository.save(notification);
    }
}
