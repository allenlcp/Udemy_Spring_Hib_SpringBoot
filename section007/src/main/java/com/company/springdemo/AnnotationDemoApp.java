package com.company.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        // read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Using constructor injection
        // get the bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        // Using setter injection
        // get the bean from spring container
        Coach bCoach = context.getBean("basketballCoach", Coach.class);

        // call a method on the bean
        System.out.println(bCoach.getDailyWorkout());
        System.out.println(bCoach.getDailyFortune());


        // Using field injection
        // get the bean from spring container
        Coach sCoach = context.getBean("soccerCoach", Coach.class);

        // call a method on the bean
        System.out.println(sCoach.getDailyWorkout());
        System.out.println(sCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
