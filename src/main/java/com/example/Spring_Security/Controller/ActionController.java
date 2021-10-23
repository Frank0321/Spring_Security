package com.example.Spring_Security.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;


@RestController
public class ActionController {

    @RolesAllowed({"ADMIN", "OFFICE", "USER"})
    @GetMapping("/")
    public String allUser(){
        return "AllUser";
    }

    @RolesAllowed({"ADMIN"})
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RolesAllowed({"ADMIN, USER"})
    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @RolesAllowed({"ADMIN, OFFICE"})
    @GetMapping("/office")
    public String office(){
        return "frank";
    }
}
