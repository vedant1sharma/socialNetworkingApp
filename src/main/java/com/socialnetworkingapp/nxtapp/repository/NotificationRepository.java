package com.socialnetworkingapp.nxtapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.socialnetworkingapp.nxtapp.model.Notification;
import java.util.List;


public interface NotificationRepository extends MongoRepository<Notification, String>{
    List<Notification> findByRecipientId(String recipientId); 
}
