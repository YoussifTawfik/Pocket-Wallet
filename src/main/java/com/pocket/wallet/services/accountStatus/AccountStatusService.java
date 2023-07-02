package com.pocket.wallet.services.accountStatus;

import com.pocket.wallet.entity.AccountStatus;
import com.pocket.wallet.exceptions.InvalidAccountStatus;
import com.pocket.wallet.exceptions.PocketWalletException;
import com.pocket.wallet.repository.AccountStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AccountStatusService {

    private final AccountStatusRepository accountStatusRepository;

    public AccountStatus getAcctStatusByCode(String code) throws PocketWalletException {
        return accountStatusRepository.getByCode(code).orElseThrow(InvalidAccountStatus::new);
    }
}
