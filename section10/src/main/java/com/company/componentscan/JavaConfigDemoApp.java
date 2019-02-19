package com.company.componentscan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // retrieve bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println("Object email: " + ((TennisCoach)theCoach).getEmailAddress());
        System.out.println("Object team: " + ((TennisCoach)theCoach).getTeam());

        // close context
        context.close();
    }
}
