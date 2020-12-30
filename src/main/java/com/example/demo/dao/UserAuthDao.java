package com.example.demo.dao;

import com.example.demo.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author 邱道长
 * 2020/12/30
 */
public interface UserAuthDao extends JpaRepository<UserAuth,Integer> {


    Optional<UserAuth> findUserAuthByUsername(String username);
}
