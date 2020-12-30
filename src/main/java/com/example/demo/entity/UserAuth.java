package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 邱道长
 * 2020/12/30
 */
@Setter
@Getter
@Entity
@Table(name = "user_auth")
public class UserAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private Boolean accountNonExpire;
    private Boolean nonLock;
    private Boolean credentialNonExpire;
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_auth_authority",
            joinColumns = {
                    @JoinColumn(name = "user_auth_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "authority_id")
            }
    )
    private List<Authority> authorities;

}
