package com.company.section4n5;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;
    private BadFortuneService badFortuneService;

    public TrackCoach(FortuneService fortuneService, BadFortuneService badFortuneService) {
        this.fortuneService = fortuneService;
        this.badFortuneService = badFortuneService;
    }

    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    public String getDailyFortune() {
        return "Just Do It:" + fortuneService.getFortune();
    }

    public String getBadDailyFortune(){
        return badFortuneService.getFortune();
    }
}
