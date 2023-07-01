package com.pocket.wallet.controllers;

import com.pocket.wallet.dto.UserDto;
import com.pocket.wallet.models.UserModel;
import com.pocket.wallet.response.GeneralResponse;
import com.pocket.wallet.response.IBasicResponse;
import com.pocket.wallet.response.ResponseMessage;
import com.pocket.wallet.services.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public IBasicResponse addUser(@RequestBody UserDto userDto) throws Exception {
        log.info(userDto.toString());
        UserModel model= userService.addUser(userDto);
        return new GeneralResponse<>(HttpStatus.OK.value(),"User "+ ResponseMessage.ADDED.getMessage(), model);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('VIEW_USERS')")
    public IBasicResponse getAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size){
        return new GeneralResponse<>(HttpStatus.OK.value(),ResponseMessage.EXECUTED.getMessage(),userService.getAllUsers(page,size));
    }
}
