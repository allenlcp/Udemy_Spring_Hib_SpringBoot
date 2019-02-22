package com.company.aopdemo.dao;

import com.company.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(Account theAccount, boolean vipFlag){
        System.out.println(getClass() + "=====>>>> Doing MY DB Work: Adding an account");
    }

    public boolean doWork(){
        System.out.println(getClass() + ": doWork()");
        return false;
    }
}
