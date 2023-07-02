package com.pocket.wallet.exceptions;

import com.pocket.wallet.exceptions.response.ErrorCodes;

/**
 * @author Youssif Tawfik
 */
public class UserNotFoundException extends PocketWalletException {

    public UserNotFoundException() {

    }

    public UserNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorCodes getErrorCode() {
        return ErrorCodes.USER_NOT_FOUND;
    }
}