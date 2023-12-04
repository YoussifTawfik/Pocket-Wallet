package com.pocket.wallet.services.account;

import com.pocket.wallet.dto.AccountDto;
import com.pocket.wallet.entity.Account;
import com.pocket.wallet.entity.AccountStatus;
import com.pocket.wallet.entity.UserEntity;
import com.pocket.wallet.exceptions.PocketWalletException;
import com.pocket.wallet.models.AccountModel;
import com.pocket.wallet.repository.AccountRepository;
import com.pocket.wallet.services.accountStatus.AccountStatusService;
import com.pocket.wallet.services.user.UserHelper;
import com.pocket.wallet.services.user.UserService;
import com.pocket.wallet.utilities.ParameterValidator;
import org.assertj.core.api.Assertions;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Youssif Tawfik
 */
@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private AccountStatusService accountStatusService;
    @Mock
    private UserService userService;
    @Mock
    private AccountHelper accountHelper;
    @Mock
    private UserHelper userHelper;
    @Mock
    private ParameterValidator parameterValidator;

    @InjectMocks
    private AccountService accountService;

    private AccountDto accountDto;
    private UserEntity user;
    private AccountStatus accountStatus;
    private Account account;
    private AccountModel accountModel;

    @BeforeEach
    public void init(){
        accountDto=new AccountDto();
        accountDto.setUserId(3L);
        accountDto.setStatus("Active");

        user=new UserEntity();
        user.setId(3L);
        user.setEmail("youssif@gmail.com");

        accountStatus =new AccountStatus();
        accountStatus.setId(1L);
        accountStatus.setCode("Active");

        account=new Account();
        account.setUser(user);
        account.setStatus(accountStatus);
        account.setBalance(0.0);

        accountModel=AccountModel.builder().status("Active").id(1L).balance(0.0).build();
    }
    @Test
    @DisplayName("Service: Create Account Test")
    @MockitoSettings(strictness = Strictness.WARN)
    void createAccount() throws PocketWalletException {
        // given
        BDDMockito.given(userService.getUserById(user.getId())).willReturn(user);
        //BDDMockito.given(parameterValidator.isNull(user)).willReturn(true);
        BDDMockito.given(accountStatusService.getAcctStatusByCode(accountStatus.getCode())).willReturn(accountStatus);
        BDDMockito.given(parameterValidator.isNull(accountStatus)).willReturn(false);
        BDDMockito.given(accountHelper.mapToModel(account)).willReturn(accountModel);
        // when
        AccountModel responseAccountModel=accountService.createAccount(accountDto);
        //then
        BDDMockito.verify(accountRepository, Mockito.times(1))
                .save(Mockito.any(Account.class));
        Assertions.assertThat(responseAccountModel).isNotNull();

    }
}