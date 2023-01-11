package com.pocket.wallet.exceptions;

import com.pocket.wallet.exceptions.response.ErrorCodes;

public class UserCategoryNotFound extends PocketWalletException {

    public UserCategoryNotFound(){

    }

    public UserCategoryNotFound(String message){
        super(message);
    }

    @Override
    public ErrorCodes getErrorCode() {
        return ErrorCodes.UNDEFINED_USER_CATEGORY;
    }

}
