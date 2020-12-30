package com.example.demo.entitywrap;

import com.example.demo.entity.Authority;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author 邱道长
 * 2020/12/30
 */
public class JpaAuthority implements GrantedAuthority {

    private Authority authority;

    public JpaAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority.getAuthority();
    }
}
