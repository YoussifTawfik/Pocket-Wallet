package com.pocket.wallet.dto;


import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class UserCategoryDto implements Serializable {

    @NonNull
    private String code;
    private Double dailyDebitLimit;
    private Double weeklyDebitLimit;
    private Double monthlyDebitLimit;
    private Double dailyCreditLimit;
    private Double weeklyCreditLimit;
    private Double monthlyCreditLimit;
}
