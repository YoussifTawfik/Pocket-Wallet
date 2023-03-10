package com.pocket.wallet.repositories;

import com.pocket.wallet.entities.UserEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("USER")
public interface UserRepository extends IWalletRepository<UserEntity> {
}
