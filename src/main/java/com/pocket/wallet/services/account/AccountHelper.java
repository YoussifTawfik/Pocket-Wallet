package com.pocket.wallet.services.account;

import com.pocket.wallet.entity.Account;
import com.pocket.wallet.models.AccountModel;
import com.pocket.wallet.services.IBasicHelper;
import com.pocket.wallet.services.user.UserHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Youssif Tawfik
 */
@Component
@RequiredArgsConstructor
public class AccountHelper implements IBasicHelper<Account, AccountModel> {

    private final UserHelper userHelper;

    @Override
    public Account mapToEntity(AccountModel model) {
        return null;
    }

    @Override
    public AccountModel mapToModel(Account entity) {
        return AccountModel.builder()
                .id(entity.getId())
                .status(entity.getStatus().getCode())
                .balance(entity.getBalance())
                .createdDate(entity.getCreatedDate())
                .lastModifiedDate(entity.getLastModifiedDate())
                .user(userHelper.mapToModel(entity.getUser()))
                .build();
    }
}
