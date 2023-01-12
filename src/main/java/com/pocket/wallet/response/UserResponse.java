package com.pocket.wallet.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UserResponse implements IBasicResponse {

    //private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String category;
}
