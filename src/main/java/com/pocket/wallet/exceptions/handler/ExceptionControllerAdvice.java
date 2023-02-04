package com.pocket.wallet.exceptions.handler;

import com.pocket.wallet.exceptions.InvalidAccountStatus;
import com.pocket.wallet.exceptions.UserCategoryNotFound;
import com.pocket.wallet.exceptions.response.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(UserCategoryNotFound.class)
    public ResponseEntity<ErrorDetails> categoryNotFound(UserCategoryNotFound ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDetails(Integer.valueOf(ex.getErrorCode().getCode()), ex.getErrorCode().getMessage()));
    }

    @ExceptionHandler(InvalidAccountStatus.class)
    public ResponseEntity<ErrorDetails> invalidAccountStatus(InvalidAccountStatus ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDetails(Integer.valueOf(ex.getErrorCode().getCode()), ex.getErrorCode().getMessage()));
    }

}
