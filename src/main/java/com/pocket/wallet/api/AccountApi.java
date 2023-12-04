package com.pocket.wallet.api;

import com.pocket.wallet.dto.AccountDto;
import com.pocket.wallet.exceptions.PocketWalletException;
import com.pocket.wallet.exceptions.response.ErrorDetails;
import com.pocket.wallet.models.AccountModel;
import com.pocket.wallet.response.IBasicResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Youssif Tawfik
 */
@Tag(name = "Account",description = "The Account API")
public interface AccountApi {

    @Operation(summary = "Creates an Account", description = "This operation creates an account entity", responses = {
            @ApiResponse(responseCode = "200", description = "Success" , content = {@Content(schema =@Schema(implementation = AccountModel.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Issue", content = {@Content(schema =@Schema(implementation = ErrorDetails.class))})
    })
    @PostMapping(
            produces = {"application/json;charset=utf-8"},
            consumes = {"application/json;charset=utf-8"})
    @PreAuthorize("hasAuthority('CREATE_ACCOUNT')")
    IBasicResponse createAccount(@Parameter(name = "The Product to be created", required = true)@RequestBody AccountDto accountDto) throws PocketWalletException;
}
