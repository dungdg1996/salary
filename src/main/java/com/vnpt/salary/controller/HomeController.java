package com.vnpt.salary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping
    public String loginPage(){
        return "login/login";
    }
}
