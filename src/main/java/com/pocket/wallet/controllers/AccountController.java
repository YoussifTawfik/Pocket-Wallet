package com.pocket.wallet.controllers;

import com.pocket.wallet.api.AccountApi;
import com.pocket.wallet.dto.AccountDto;
import com.pocket.wallet.exceptions.PocketWalletException;
import com.pocket.wallet.models.AccountModel;
import com.pocket.wallet.response.GeneralResponse;
import com.pocket.wallet.response.IBasicResponse;
import com.pocket.wallet.response.ResponseMessage;
import com.pocket.wallet.services.account.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Youssif Tawfik
 */
@RestController
@RequestMapping("/accounts")
@Slf4j
@RequiredArgsConstructor
public class AccountController implements AccountApi {

    private final AccountService accountService;

    @Override
    public IBasicResponse createAccount(@Valid AccountDto accountDto) throws PocketWalletException {
        log.info(accountDto.toString());
        AccountModel model= accountService.createAccount(accountDto);
        return new GeneralResponse<>(HttpStatus.OK.value(),"Account "+ ResponseMessage.ADDED.getMessage(), model);
    }

}
