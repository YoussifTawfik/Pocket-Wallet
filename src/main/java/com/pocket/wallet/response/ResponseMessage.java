package com.pocket.wallet.response;

public enum  ResponseMessage {

    ADDED("Added Successfully"), UPDATED("Updated Successfully"), DELETED("Deleted Successfully"),
    EXECUTED("Executed Successfully");

    private final String message;

    ResponseMessage(String msg){
        this.message=msg;
    }

    public String getMessage(){
        return this.message;
    }
}
