package com.pocket.wallet.repositories;

import com.pocket.wallet.entities.UserCategory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("USER_CATEGORY")
public interface UserCategoryRepository extends IWalletRepository<UserCategory> {

    UserCategory getByCode(String code);
}
