package com.pocket.wallet.controllers;

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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Youssif Tawfik
 */
@RestController
@RequestMapping("/accounts")
@Slf4j
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;


    @PostMapping
    @PreAuthorize("hasAuthority('CREATE_ACCOUNT')")
    public IBasicResponse createAccount(@RequestBody AccountDto accountDto) throws PocketWalletException {
        log.info(accountDto.toString());
        AccountModel model= accountService.createAccount(accountDto);
        return new GeneralResponse<>(HttpStatus.OK.value(),"Account "+ ResponseMessage.ADDED.getMessage(), model);
    }

}
