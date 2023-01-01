package com.pocket.wallet.exceptions;

public class UserCategoryNotFound extends PocketWalletException {

    public UserCategoryNotFound(){

    }

    public UserCategoryNotFound(String message){
        super(message);
    }

}
