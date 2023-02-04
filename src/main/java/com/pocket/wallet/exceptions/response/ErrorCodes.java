package com.pocket.wallet.exceptions.response;

public enum ErrorCodes {

    UNDEFINED_USER_CATEGORY(Prefix.USER.getPrefix()+"01","Undefined User Category"),
    INVALID_ACCOUNT_STATUS(Prefix.ACCOUNT.getPrefix()+"01","Invalid Account Status");

    private String message;
    private final String code;

    ErrorCodes(String code, String message){
        this.code=code;
        this.message=message;
    }

    public String getMessage(){
        return this.message;
    }

    public String getCode(){
        return this.code;
    }


    private enum Prefix{
        USER("1"), ACCOUNT("2");

        private String pre;

        private Prefix(String pre){
            this.pre=pre;
        }

        public String getPrefix(){
            return this.pre;
        }

    }

}
