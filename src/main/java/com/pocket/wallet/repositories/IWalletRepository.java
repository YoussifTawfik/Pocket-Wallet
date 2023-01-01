package com.pocket.wallet.repositories;

import com.pocket.wallet.entities.BasicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWalletRepository<E extends BasicEntity> extends JpaRepository<E, Long> {

}
