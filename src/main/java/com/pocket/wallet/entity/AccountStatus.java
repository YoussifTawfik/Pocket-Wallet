package com.pocket.wallet.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@Table(name = "ACCOUNT_STATUS")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountStatus extends BasicEntity {

    @Column(nullable = false)
    private String code;

    private String description;
}
