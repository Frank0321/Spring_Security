package com.example.Spring_Security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * FileName : UserRepository
 * CreatTime : 2021/11/16
 * Author : Frank.Chang
 * Description :
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String userName);

}
