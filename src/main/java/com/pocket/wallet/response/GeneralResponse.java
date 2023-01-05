package com.pocket.wallet.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GeneralResponse<T> implements IBasicResponse  {

    private int status;
    private String message;
    private T body;

}
