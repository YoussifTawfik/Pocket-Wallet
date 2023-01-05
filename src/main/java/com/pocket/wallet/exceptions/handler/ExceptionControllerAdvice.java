package com.pocket.wallet.exceptions.handler;

import com.pocket.wallet.exceptions.UserCategoryNotFound;
import com.pocket.wallet.exceptions.response.ErrorCodes;
import com.pocket.wallet.exceptions.response.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(UserCategoryNotFound.class)
    public ResponseEntity<ErrorDetails> categoryNotFound(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDetails(ErrorCodes.UNDEFINED_USER_CATEGORY.getCode()));
    }

}
