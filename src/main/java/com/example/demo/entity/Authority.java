package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author 邱道长
 * 2020/12/30
 */
@Setter
@Getter
@Entity
@Table
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name; // 名称
    private String authority;// 具体授权
    private String description; // 更加详细的描述
    private String uri; // 假设基于URI
    private String method; // 方法类型


    @ManyToMany
    @JoinTable(
            name = "user_auth_authority",
            joinColumns = {
                    @JoinColumn(name = "authority_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_auth_id")
            }
    )
    private List<UserAuth> userAuths;
}
