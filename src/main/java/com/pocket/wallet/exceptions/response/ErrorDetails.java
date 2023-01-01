package com.pocket.wallet.exceptions.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class ErrorDetails {

    private String message;
    private String description;

    public ErrorDetails( String msg){
        message=msg;
    }

    public ErrorDetails( String message, String description) {
        this.message = message;
        this.description = description;
    }
}
