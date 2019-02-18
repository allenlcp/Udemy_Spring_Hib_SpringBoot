package com.company.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
    public String getFortune() {
        return "Calling getFortune() method from HappyFortuneService.class ";
    }
}
