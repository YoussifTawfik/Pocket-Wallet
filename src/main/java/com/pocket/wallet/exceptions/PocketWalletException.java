package com.pocket.wallet.exceptions;

public class PocketWalletException extends RuntimeException {

    public PocketWalletException(){
        super();
    }

    public PocketWalletException(String message){
        super(message);
    }

}
