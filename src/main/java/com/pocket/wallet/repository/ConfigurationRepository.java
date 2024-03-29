package com.pocket.wallet.repository;

import com.pocket.wallet.entity.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends IWalletRepository<Configuration> {

    @Query("Select c from Configuration c where c.code =:code")
    Configuration getByCode(@Param("code") String code);
}
