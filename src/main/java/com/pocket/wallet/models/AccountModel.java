package com.pocket.wallet.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Youssif Tawfik
 */
@Getter
@Setter
@ToString
@Builder
public class AccountModel implements IBasicModel {

    private Long id;
    private String status;
    private double balance;
    private UserModel user;
    private Date createdDate;
    protected Date lastModifiedDate;
}
