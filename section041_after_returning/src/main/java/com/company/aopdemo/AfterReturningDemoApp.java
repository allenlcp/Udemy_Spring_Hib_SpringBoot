package com.company.aopdemo;

import com.company.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> theAccounts = theAccountDAO.findAccounts();

        // display the account
        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        theAccounts.stream()
                   .forEach(System.out::println);

        // close the context
        context.close();
    }
}
