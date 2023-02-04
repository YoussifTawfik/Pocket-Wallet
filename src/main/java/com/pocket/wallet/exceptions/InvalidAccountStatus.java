package com.pocket.wallet.exceptions;

import com.pocket.wallet.exceptions.response.ErrorCodes;

public class InvalidAccountStatus extends PocketWalletException {

    public InvalidAccountStatus(){

    }

    public InvalidAccountStatus(String message){
        super(message);
    }

    @Override
    public ErrorCodes getErrorCode() {
        return ErrorCodes.INVALID_ACCOUNT_STATUS;
    }

}
