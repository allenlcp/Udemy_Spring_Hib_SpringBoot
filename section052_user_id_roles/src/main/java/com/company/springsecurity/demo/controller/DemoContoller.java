package com.company.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoContoller {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }
}
