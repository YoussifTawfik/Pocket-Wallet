package com.pocket.wallet.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@Table(name = "USER_CATEGORY")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCategory extends BasicEntity {

    @Column(name = "CODE")
    private String code;

    @Column(name = "DAILY_DEBIT_LIMIT",nullable = false)
    private Double dailyDebitLimit;

    @Column(name = "WEEKLY_DEBIT_LIMIT")
    private Double weeklyDebitLimit;

    @Column(name = "MONTHLY_DEBIT_LIMIT")
    private Double monthlyDebitLimit;

    @Column(name = "DAILY_CREDIT_LIMIT")
    private Double dailyCreditLimit;

    @Column(name = "WEEKLY_CREDIT_LIMIT")
    private Double weeklyCreditLimit;

    @Column(name = "MONTHLY_CREDIT_LIMIT")
    private Double monthlyCreditLimit;
}
