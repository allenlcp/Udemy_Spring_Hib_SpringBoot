package com.company.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public boolean addMembershipAccount(){
        System.out.println(getClass() + "=====>>>> Doing MY DB Work: Adding an membership");
        return false;
    }

    public void doToSleep(){
        System.out.println(getClass() + ": doToSleep()");
    }
}
