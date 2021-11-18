package com.example.Spring_Security;

import com.example.Spring_Security.model.User;
import com.example.Spring_Security.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * FileName : MyUserDetailsService
 * CreatTime : 2021/11/16
 * Author : Frank.Chang
 * Description : 2. 實作 UserDetailsService，以 MyUserDetails 的內容為主
 */
@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(()-> new UsernameNotFoundException("Not find"+ userName));

        return user.map(MyUserDetails::new).get();
    }
}
