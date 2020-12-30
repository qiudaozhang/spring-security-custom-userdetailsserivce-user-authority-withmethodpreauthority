package com.example.demo.security.services;

import com.example.demo.dao.UserAuthDao;
import com.example.demo.entity.UserAuth;
import com.example.demo.entitywrap.JpaUserDetails;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author 邱道长
 * 2020/12/30
 */
public class JpaUserDetailsService implements UserDetailsService {

    @Resource
    private UserAuthDao userAuthDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAuth> op = userAuthDao.findUserAuthByUsername(username);
        UserAuth ua = op.orElseThrow(() -> new BadCredentialsException("bad"));
        UserDetails ud  = new JpaUserDetails(ua);
        return ud;
    }
}
