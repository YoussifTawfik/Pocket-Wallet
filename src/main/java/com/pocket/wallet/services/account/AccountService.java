package com.pocket.wallet.services.account;

import com.pocket.wallet.dto.AccountDto;
import com.pocket.wallet.entity.Account;
import com.pocket.wallet.entity.AccountStatus;
import com.pocket.wallet.entity.UserEntity;
import com.pocket.wallet.exceptions.InvalidAccountStatus;
import com.pocket.wallet.exceptions.PocketWalletException;
import com.pocket.wallet.exceptions.UserNotFoundException;
import com.pocket.wallet.models.AccountModel;
import com.pocket.wallet.repository.AccountRepository;
import com.pocket.wallet.services.accountStatus.AccountStatusService;
import com.pocket.wallet.services.user.UserService;
import com.pocket.wallet.utilities.ParameterValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Youssif Tawfik
 */
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountStatusService accountStatusService;
    private final UserService userService;
    private final AccountHelper accountHelper;
    private final ParameterValidator parameterValidator;

    public AccountModel createAccount(AccountDto accountDto) throws PocketWalletException {
        Account account=new Account();
        UserEntity user= userService.getUserById(accountDto.getUserId());
        if(parameterValidator.isNull(user)) throw new UserNotFoundException();
        AccountStatus status=accountStatusService.getAcctStatusByCode(accountDto.getStatus());
        if(parameterValidator.isNull(status)) throw new InvalidAccountStatus();
        account.setBalance(0.0);
        account.setUser(user);
        account.setStatus(status);
        accountRepository.save(account);
       return accountHelper.mapToModel(account);
    }


}
