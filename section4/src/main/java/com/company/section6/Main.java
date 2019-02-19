package com.company.section6;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);
        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        // check if they are the same
        boolean result = (theCoach == alphaCoach);

        // printing result
        System.out.println("\nPointing to the same object: " + result);
        System.out.println("\nMemory location of theCoach: " + theCoach);
        System.out.println("\nMemory location of alphaCoach: " + alphaCoach);


        // close the context
        context.close();
    }
}
