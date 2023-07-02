package com.pocket.wallet.exceptions;

import com.pocket.wallet.exceptions.response.ErrorCodes;

public abstract class PocketWalletException extends Exception {

    public PocketWalletException(){
        super();
    }

    public PocketWalletException(String message){
        super(message);
    }

    public abstract ErrorCodes getErrorCode();

}
