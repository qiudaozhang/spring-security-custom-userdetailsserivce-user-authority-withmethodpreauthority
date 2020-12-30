package com.example.demo.config;

import com.example.demo.security.services.JpaUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author 邱道长
 * 2020/12/30
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启全局方法安全 这样！@PreAuthority等注解就能生效
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public JpaUserDetailsService jpaUserDetailsService() {
        return new JpaUserDetailsService();
    }


    // 必须有，否则会有非法参数异常
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .anyRequest()
                .authenticated();
        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/welcome",true)
                .permitAll();
    }
}
