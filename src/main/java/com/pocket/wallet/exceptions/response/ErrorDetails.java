package com.pocket.wallet.exceptions.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ErrorDetails {

    private Integer code;
    private String message;
    private LocalDateTime timeStamp;

    public ErrorDetails(Integer code, String msg){
        message=msg;
        this.code=code;
        this.timeStamp=LocalDateTime.now();
    }

}
