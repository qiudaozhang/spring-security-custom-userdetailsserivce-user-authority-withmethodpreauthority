package com.example.demo.entitywrap;

import com.example.demo.entity.Authority;
import com.example.demo.entity.UserAuth;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 邱道长
 * 2020/12/30
 */
public class JpaUserDetails implements UserDetails {

    private UserAuth userAuth;

    public JpaUserDetails(UserAuth userAuth) {
        this.userAuth = userAuth;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Authority> authorities = userAuth.getAuthorities();
        List<JpaAuthority> collect = authorities.stream().map(c -> new JpaAuthority(c)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public String getPassword() {
        return userAuth.getPassword();
    }

    @Override
    public String getUsername() {
        return userAuth.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userAuth.getAccountNonExpire();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userAuth.getNonLock();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userAuth.getCredentialNonExpire();
    }

    @Override
    public boolean isEnabled() {
        return userAuth.getEnabled();
    }
}
