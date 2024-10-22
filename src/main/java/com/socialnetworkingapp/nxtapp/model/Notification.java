package com.socialnetworkingapp.nxtapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "notifications")
@Getter
@Setter
public class Notification {
    @Id
    private String id;
    private String senderId;
    private String recipientId;
    private String message;
    private boolean isRead;
    private Date timestamp;
}
