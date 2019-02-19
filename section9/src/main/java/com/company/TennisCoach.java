package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${foo.email}")
    private String emailAddress;

    @Value("${foo.team}")
    private String team;

    @Autowired
    public TennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
        System.out.println(">> TennisCoach: inside constructor");
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "Practice your backhand";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // add an init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println(">> TennisCoach: inside method doMyStartupStuff");
    }

    // add a destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println(">> TennisCoach: inside method doMyCleanupStuff");
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }
}
