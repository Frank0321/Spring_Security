package com.example.Spring_Security.policy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

import static java.lang.String.format;

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
        return "save is finish";
    }

    /**
     * 修改資料的方法，需要先從資料庫抓出來，然後修改後，在回傳回去資料中
     */
    public PolicyEntity modify(Long id, String name, String empId) {
        return policyRepository.findById(id)
                .map(p ->{
                    p.setName(name);
                    p.setEmpId(empId);
                    return p;
                })
                .map(policyRepository::save)
                .orElseThrow(()-> new IllegalArgumentException(format("id %s not exits", id)));
    }
}
