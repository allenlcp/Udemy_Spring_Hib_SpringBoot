package com.company.aopdemo;

import com.company.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> theAccounts = null;

        try {
            boolean tripWire = false;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception e){
            System.out.println("\n\nMain Program.. caught exception: " + e);
        }

        // display the account
        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println(theAccounts);

        // close the context
        context.close();
    }
}
