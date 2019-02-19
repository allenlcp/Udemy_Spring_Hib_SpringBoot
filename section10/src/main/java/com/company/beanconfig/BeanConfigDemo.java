package com.company.beanconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanConfigDemo {

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // retrieve bean from spring container
        Coach theCoach = context.getBean("swimCoach", Coach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println(((SwimCoach)theCoach).getEmail());
        System.out.println(((SwimCoach)theCoach).getTeam());

        // close context
        context.close();
    }
}
