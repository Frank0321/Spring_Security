package com.example.Spring_Security.policy;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * FileName : Policy
 * CreatTime : 2021/11/19
 * Author : Frank.Chang
 * Description :
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String empId;

}
