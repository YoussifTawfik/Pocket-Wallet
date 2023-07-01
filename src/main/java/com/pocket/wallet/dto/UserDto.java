package com.pocket.wallet.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto implements IBasicDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String category;
}
