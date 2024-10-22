package com.socialnetworkingapp.nxtapp.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {

    private String userId;
    private String content;
    private Date timestamp;
    
}
