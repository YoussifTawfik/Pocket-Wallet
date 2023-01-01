package com.pocket.wallet.controllers;

import com.pocket.wallet.dto.AddUserDto;
import com.pocket.wallet.response.IBasicResponse;
import com.pocket.wallet.services.user.UserService;
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

    public UserController (UserService userService){
        this.userService=userService;
    }

    @PostMapping
    public ResponseEntity<IBasicResponse> addUser(@RequestBody AddUserDto addUserDto){
        log.info(addUserDto.toString());
        return ResponseEntity.status(HttpStatus.OK).body(userService.addUser(addUserDto));
    }
}
