package com.company.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach{

    private FortuneService fortuneService;

    public BasketballCoach() {
        System.out.println(">> Basketball coach: inside default constructor");
    }

    @Autowired
    @Qualifier("happyFortuneService")
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">> Basketball coach: inside setFortuneService() method");
        this.fortuneService = fortuneService;
    }


    public String getDailyWorkout() {
        return "Shoot hoops";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
