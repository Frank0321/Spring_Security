package com.example.Spring_Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * FileName : SecurityConfig
 * CreatTime : 2021/11/24
 * Author : Frank.Chang
 * Description :
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                    .loginPage("/login_page")
                    .loginProcessingUrl("/perform_login")
                    .failureUrl("/login_page?error")
                .and()
                .logout()
                    .logoutUrl("/perform_logout")
                    .logoutSuccessUrl("/login_page?logout");
    }
}
