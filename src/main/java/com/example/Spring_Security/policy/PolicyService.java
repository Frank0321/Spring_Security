package com.example.Spring_Security.policy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

/**
 * FileName : PolicyService
 * CreatTime : 2021/11/19
 * Author : Frank.Chang
 * Description :
 */
@Service
@RequiredArgsConstructor
public class PolicyService {

    private final PolicyRepository policyRepository;

    public List<PolicyEntity> findAll() {
        return policyRepository.findAll();
    }

    public String saveOne(PolicyEntity policyEntity) {
        policyRepository.save(policyEntity);
        return "save is finsish";
    }
}
