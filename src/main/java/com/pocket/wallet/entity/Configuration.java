package com.pocket.wallet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@Table(name = "CONFIGURATION")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Configuration extends BasicEntity {

    @Column(name = "CODE",nullable = false)
    private String code;

    @Column(name = "VALUE",nullable = false)
    private String value;

    @Column(name = "DESCRIPTION")
    private String description;

}
