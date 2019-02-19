package com.company;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class HappyFortuneService implements FortuneService {
    public String getFortune() {
        return "Calling getFortune() method from HappyFortuneService.class ";
    }

    // add an init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println(">> HappyFortuneService: inside method doMyStartupStuff");
    }

    // add a destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println(">> HappyFortuneService: inside method doMyCleanupStuff");
    }
}
