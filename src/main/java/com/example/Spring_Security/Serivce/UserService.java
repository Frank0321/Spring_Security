package com.example.Spring_Security.Serivce;

import com.example.Spring_Security.Entity.UserDao;
import com.example.Spring_Security.Entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.getByUsername(username)
                .map(e -> User.withUsername(e.getUsername())
                            .password("{noop}" + e.getPassword())
                            .roles(e.getRole())
                            .build()).orElse(null);
    }

}
