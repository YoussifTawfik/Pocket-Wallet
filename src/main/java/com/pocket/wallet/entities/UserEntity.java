package com.pocket.wallet.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@ToString
public class UserEntity extends BasicEntity {

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL",unique = true)
    private String email;

    @Column(name = "PHONE", unique = true)
    @NotNull
    private String phone;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_CATEGORY_ID")
    private UserCategory userCategory;
}
