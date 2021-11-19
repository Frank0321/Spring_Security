package com.example.Spring_Security.policy;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * FileName : PolicyController
 * CreatTime : 2021/11/19
 * Author : Frank.Chang
 * Description :
 */
@RestController
@RequestMapping("/policy")
@RequiredArgsConstructor
public class PolicyController {

    private final PolicyService policyService;

    @GetMapping
    public List<PolicyEntity> findAll(){
        return policyService.findAll();
    }

    @GetMapping("/save")
    public String saveOne(@RequestParam String name, @RequestParam String empId){
        PolicyEntity policyEntity = PolicyEntity.builder().name(name).empId(empId).build();
        return policyService.saveOne(policyEntity);
    }
}
