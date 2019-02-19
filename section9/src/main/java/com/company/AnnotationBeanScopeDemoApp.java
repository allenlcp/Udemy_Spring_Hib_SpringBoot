package com.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        // load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        boolean sameObj = (theCoach == alphaCoach);
        System.out.println("\nPointing to the same object: " + sameObj);
        System.out.println("\nMemory location for theCoach: " + theCoach);
        System.out.println("\nMemory location for alphaCoach: " + alphaCoach);

        System.out.println("Object email: " + ((TennisCoach)theCoach).getEmailAddress());
        System.out.println("Object team: " + ((TennisCoach)theCoach).getTeam());

        // close context
        context.close();
    }
}
