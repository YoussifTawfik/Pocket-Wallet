package com.pocket.wallet.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Youssif Tawfik
 */
@Data
@AllArgsConstructor
public class LoginResponse implements IBasicResponse{

    private String access_token;
}
