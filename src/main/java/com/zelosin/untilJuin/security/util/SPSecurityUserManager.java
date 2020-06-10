package com.zelosin.untilJuin.security.util;

import com.zelosin.untilJuin.entities.users.info.SPUser;
import com.zelosin.untilJuin.services.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SPSecurityUserManager implements UserDetailsService {

    @Autowired
    private UserServiceInter userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userService.findUserByLogin(s);
    }
}
