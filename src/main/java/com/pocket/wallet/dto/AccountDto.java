package com.pocket.wallet.dto;

import lombok.Data;

/**
 * @author Youssif Tawfik
 */
@Data
public class AccountDto implements IBasicDto {

    private String status;
    private Long userId;
}
