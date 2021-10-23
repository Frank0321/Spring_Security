package com.example.Spring_Security.Entity;


import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserDao {

    private final UserRepo userRepo;

    @PostConstruct
    void init(){
        List<UserEntity> userList = List.of(UserEntity.builder().username("admin").password("admin").role("ADMIN").build(),
                                            UserEntity.builder().username("office").password("123").role("OFFICE").build(),
                                            UserEntity.builder().username("user").password("456").role("USER").build());
        userRepo.saveAll(userList);
    }

    public Optional<UserEntity> getByUsername(String username) {
        return userRepo.findByUsername(username);
    }

}
