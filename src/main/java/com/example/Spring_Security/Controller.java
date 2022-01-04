package com.example.Spring_Security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * FileName : Controller
 * CreatTime : 2022/1/4
 * Author : Frank.Chang
 * Description :
 */
@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/admin/hello")
    public Map<String, String> adminSayHello(){
        Map<String, String> result = Map.of("message", "admin say hello");
        return result;
    }

    @GetMapping("/user/hello")
    public Map<String, String> userSayHello(){
        Map<String, String> result = Map.of("message", "user say hello");
        return result;
    }
}
