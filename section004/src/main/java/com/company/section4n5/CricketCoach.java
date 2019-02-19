package com.company.section4n5;

public class CricketCoach implements Coach {

    private String emailAddress;
    private String team;
    private FortuneService fortuneService;  // For object injection

    // creat a no-arg constructor
    public CricketCoach() {
        System.out.println("In CricketCoach.class constructor");
    }

    // our setter method


    public void setEmailAddress(String emailAddress) {
        System.out.println("CricketCoach.setEmailAddress() - setter method");
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach.setTeam() - setter method");
        this.team = team;
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach.setFortuneService() - setter method");
        this.fortuneService = fortuneService;
    }


    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public String getDailyWorkout() {
        return "Practice fast bowling for 15 mins";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
