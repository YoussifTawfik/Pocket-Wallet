package com.pocket.wallet.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddUserResponse implements IBasicResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    private String category;
}
