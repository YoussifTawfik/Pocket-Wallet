package com.pocket.wallet.repository;

import com.pocket.wallet.entity.BasicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWalletRepository<E extends BasicEntity> extends JpaRepository<E, Long> {

}
