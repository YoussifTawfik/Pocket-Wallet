package com.pocket.wallet.controllers;

import com.pocket.wallet.dto.UserDto;
import com.pocket.wallet.models.UserModel;
import com.pocket.wallet.response.GeneralResponse;
import com.pocket.wallet.response.IBasicResponse;
import com.pocket.wallet.response.ResponseMessage;
import com.pocket.wallet.response.UserResponse;
import com.pocket.wallet.services.user.UserService;
import com.pocket.wallet.transfomers.UserTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserTransformer userTransformer;

    public UserController (UserService userService, UserTransformer userTransformer){
        this.userService=userService;
        this.userTransformer=userTransformer;
    }

    @PostMapping
    public GeneralResponse<IBasicResponse> addUser(@RequestBody UserDto userDto) throws Exception {
        log.info(userDto.toString());
        // Transform Request
        UserModel model=userTransformer.transformRequest(userDto);
        // Process Request
        model=userService.addUser(model);
        // Transform Response
        UserResponse response=userTransformer.transformResponse(model);
        return new GeneralResponse<>(HttpStatus.OK.value(),"User "+ ResponseMessage.ADDED.getMessage(), response);
    }
}
