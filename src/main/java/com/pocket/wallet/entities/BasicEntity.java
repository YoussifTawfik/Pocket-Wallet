package com.pocket.wallet.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@ToString
@MappedSuperclass
public class BasicEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
}
