package com.company.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {

    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;

    public SoccerCoach() {
    }

    public String getDailyWorkout() {
        return "bend the ball";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
