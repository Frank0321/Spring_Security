package com.example.Spring_Security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * FileName : LoginPageController
 * CreatTime : 2021/11/24
 * Author : Frank.Chang
 * Description :
 */
@Controller
public class LoginPageController {

    @GetMapping("login_page")
    public String login_page(){
        return "login";
    }

    @GetMapping("logout_page")
    public String logout_page(){
        return "logout";
    }
}
