package com.company.aopdemo;

import com.company.aopdemo.dao.AccountDAO;
import com.company.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        Account myAccount = context.getBean("account", Account.class);

        // call the business method
        myAccount.setName("Mark");
        myAccount.setLevel("Gold");
        theAccountDAO.addAccount(myAccount, true);
        theAccountDAO.doWork();

        // call teh accountdao getter/setter methods
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");
        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();

        // call the membership business method
        theMembershipDAO.addMembershipAccount();
        theMembershipDAO.doToSleep();

        // close the context
        context.close();
    }
}
