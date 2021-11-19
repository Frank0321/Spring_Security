package com.example.Spring_Security.policy;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileName : PolicyRepository
 * CreatTime : 2021/11/19
 * Author : Frank.Chang
 * Description :
 */
public interface PolicyRepository extends JpaRepository<PolicyEntity, Long> {
}
