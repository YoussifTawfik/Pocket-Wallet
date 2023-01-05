package com.pocket.wallet.repositories;

import com.pocket.wallet.entities.UserCategory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("USER_CATEGORY")
public interface UserCategoryRepository extends IWalletRepository<UserCategory> {

    @Query("select categ from UserCategory categ where categ.code =:code")
    UserCategory getByCode(@Param("code") String code);
}
