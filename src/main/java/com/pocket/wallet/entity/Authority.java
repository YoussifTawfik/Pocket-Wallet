package com.pocket.wallet.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * @author Youssif Tawfik
 */
@Entity
@Table(name = "Authority")
@Getter
@Setter
public class Authority extends BasicEntity {

    @Column(name = "CODE", unique = true, nullable = false)
    private String code;
    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany(mappedBy = "authorities")
    private Set<UserEntity> users;
}
