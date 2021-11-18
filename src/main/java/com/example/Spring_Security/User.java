package com.example.Spring_Security;

import lombok.*;

import javax.persistence.*;

/**
 * FileName : User
 * CreatTime : 2021/11/16
 * Author : Frank.Chang
 * Description :
 */
@Entity
@Table(name = "User")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userName;

    private String password;

    private boolean active;

    private String roles;
}
