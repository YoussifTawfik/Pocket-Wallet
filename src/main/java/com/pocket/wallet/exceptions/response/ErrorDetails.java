package com.pocket.wallet.exceptions.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ErrorDetails {

    private String message;
    private String description;
    private LocalDateTime timeStamp;

    public ErrorDetails( String msg){
        message=msg;
        this.timeStamp=LocalDateTime.now();
    }

    public ErrorDetails( String message, String description) {
        this(message);
        this.description = description;
    }
}
