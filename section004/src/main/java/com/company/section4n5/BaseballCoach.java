package com.company.section4n5;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "BaseballCoach.getDailyWorkout()";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
