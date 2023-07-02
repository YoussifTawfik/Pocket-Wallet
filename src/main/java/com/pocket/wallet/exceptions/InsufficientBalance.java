package com.pocket.wallet.exceptions;

import com.pocket.wallet.exceptions.response.ErrorCodes;

/**
 * @author Youssif Tawfik
 */
public class InsufficientBalance extends PocketWalletException {

    public InsufficientBalance() {

    }

    public InsufficientBalance(String message) {
        super(message);
    }

    @Override
    public ErrorCodes getErrorCode() {
        return ErrorCodes.INSUFFICIENT_BALANCE;
    }
}