package com.pocket.wallet.exceptions.response;

public enum ErrorCodes {

    UNDEFINED_USER_CATEGORY(101,"Undefined User Category");

    private String message;
    private final Integer code;

    ErrorCodes(Integer code, String message){
        this.code=code;
        this.message=message;
    }

    public String getMessage(){
        return this.message;
    }

    public Integer getCode(){
        return this.code;
    }

}
