package com.pocket.wallet.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * @author Youssif Tawfik
 */
@Entity
@Table(name = "ACCOUNTS")
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Account extends BasicEntity {

    private double balance;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_STATUS_ID")
    private AccountStatus status;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date createdDate;

    @LastModifiedBy
    protected String lastModifiedBy;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    protected Date lastModifiedDate;

}
