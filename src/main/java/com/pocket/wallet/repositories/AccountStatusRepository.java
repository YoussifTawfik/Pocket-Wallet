package com.pocket.wallet.repositories;

import com.pocket.wallet.entities.AccountStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountStatusRepository extends IWalletRepository<AccountStatus> {


    @Query("select acs from AccountStatus acs where acs.code =:code")
    Optional<AccountStatus> getByCode(@Param("code") String code);

}
