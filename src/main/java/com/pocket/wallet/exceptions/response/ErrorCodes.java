package com.pocket.wallet.exceptions.response;

public enum ErrorCodes {

    UNDEFINED_USER_CATEGORY("Undefined User Category");

    private String code;

    ErrorCodes(String code){
        this.code=code;
    }

    public String getCode(){
        return this.code;
    }

}
