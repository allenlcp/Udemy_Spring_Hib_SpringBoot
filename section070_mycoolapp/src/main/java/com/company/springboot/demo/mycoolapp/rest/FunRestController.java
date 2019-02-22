package com.company.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    // expose "/" endpoint

    @GetMapping("/")
    public String sayHello(){
        return "Hello World, time on server is " + LocalDateTime.now();
    }
}
