package com.pocket.wallet.services.accountStatus;

import com.pocket.wallet.entities.AccountStatus;
import com.pocket.wallet.exceptions.InvalidAccountStatus;
import com.pocket.wallet.repositories.AccountStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AccountStatusService {

    private final AccountStatusRepository accountStatusRepository;

    public AccountStatus getAcctStatusByCode(String code){
        return accountStatusRepository.getByCode(code).orElseThrow(InvalidAccountStatus::new);
    }
}
