package com.pocket.wallet.repository;

import com.pocket.wallet.entity.UserEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("USER")
public interface UserRepository extends IWalletRepository<UserEntity> {

    UserEntity getByEmail(String email);
}
