package com.pocket.wallet.controllers;

import com.pocket.wallet.dto.LoginDto;
import com.pocket.wallet.dto.UserDto;
import com.pocket.wallet.models.UserModel;
import com.pocket.wallet.response.GeneralResponse;
import com.pocket.wallet.response.IBasicResponse;
import com.pocket.wallet.response.LoginResponse;
import com.pocket.wallet.response.ResponseMessage;
import com.pocket.wallet.security.JwtTokenUtil;
import com.pocket.wallet.security.JwtUserDetailsService;
import com.pocket.wallet.services.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * @author Youssif Tawfik
 */
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService userDetailsService;
    private final UserService userService;


    @PostMapping("/auth")
    public IBasicResponse createAuthenticationToken(@RequestBody LoginDto loginDto) throws Exception {

        authenticate(loginDto.getEmail(), loginDto.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(loginDto.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return new GeneralResponse<>(HttpStatus.OK.value(),"Logged in successfully", new LoginResponse(token));
    }

    @PostMapping("/register")
    public IBasicResponse addUser(@RequestBody UserDto userDto) throws Exception {
        log.info(userDto.toString());
        UserModel model= userService.addUser(userDto);
        return new GeneralResponse<>(HttpStatus.OK.value(),"User "+ ResponseMessage.ADDED.getMessage(), model);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
