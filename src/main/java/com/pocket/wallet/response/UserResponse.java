package com.pocket.wallet.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserResponse implements IBasicResponse {

    //private Long id;
    private String asyncId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String category;
}
