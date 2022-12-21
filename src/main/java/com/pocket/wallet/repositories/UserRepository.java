package com.pocket.wallet.repositories;

import com.pocket.wallet.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends WalletRepository<User> {
}
