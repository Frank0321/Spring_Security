package com.example.Spring_Security.policy;

import com.example.Spring_Security.User;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * FileName : Policy
 * CreatTime : 2021/11/19
 * Author : Frank.Chang
 * Description : 使用 security 登入為資料建立名稱 :
 * 1. 使用 @EntityListeners(AuditingEntityListener.class)，才能使用 @CreatedBy、@LastModifiedBy
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class PolicyEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String empId;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;

}
