package com.pocket.wallet.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UserCategoryModel implements IBasicModel {

    private String code;
    private Double dailyDebitLimit;
    private Double weeklyDebitLimit;
    private Double monthlyDebitLimit;
    private Double dailyCreditLimit;
    private Double weeklyCreditLimit;
    private Double monthlyCreditLimit;
}
