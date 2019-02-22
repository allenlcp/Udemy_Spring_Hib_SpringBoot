package com.company.aopdemo;

import com.company.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {

    private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("Calling getFortune");

        boolean tripWire = true;
        try{
            String data = theFortuneService.getFortune(tripWire);
            myLogger.info("\nMy fortune is: " + data);
        } catch (Exception e){
            System.out.println("Exception catch in main :" + e);
        }

        myLogger.info("Finished");

        // close the context
        context.close();
    }
}
