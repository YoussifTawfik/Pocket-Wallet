package com.pocket.wallet.security;

import com.pocket.wallet.entity.UserEntity;
import com.pocket.wallet.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Youssif Tawfik
 */
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user= userService.getUserByEmail(username);
        if(user==null)
            throw new UsernameNotFoundException("Can't find user with email: "+username);
        Set<GrantedAuthority> authorityList=prepareAuthorities(user);
        return new User(user.getEmail(),user.getPassword(),authorityList);
    }

    private Set<GrantedAuthority> prepareAuthorities(UserEntity user){
        return user.getAuthorities().stream().map(a->new SimpleGrantedAuthority(a.getCode())).collect(Collectors.toSet());
    }
}
