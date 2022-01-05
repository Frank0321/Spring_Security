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

    /**
     * http://localhost:8081/policy/save?name=Frank&empId=1234
     * @param name
     * @param empId
     * @return
     */
    @GetMapping("/save")
    public String saveOne(@RequestParam String name, @RequestParam String empId){
        PolicyEntity policyEntity = PolicyEntity.builder().name(name).empId(empId).build();
        return policyService.saveOne(policyEntity);
    }

    /**
     * http://localhost:8081/policy/save/3?name=ABC&empId=12345
     * @param name
     * @param empId
     * @param id
     * @return
     */
    @GetMapping("modify/{id}")
    public PolicyEntity update(@RequestParam String name, @RequestParam String empId, @PathVariable("id") Long id){
        return policyService.modify(id, name, empId);
    }
}
