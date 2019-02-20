package com.company.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//    @Before("execution(public void addAccount())")  // -> Any method called addAccount()
//    public void beforeAddAccountAdvice(){
//        System.out.println(getClass() + " =====>>>> Executing @Before advice on addAccount()");
//    }

//    @Before("execution(public void com.company.aopdemo.dao.AccountDAO.addAccount())")  // -> Specific method addAccount
//    public void beforeAddAccountAdvice(){
//        System.out.println(getClass() + " =====>>>> Executing @Before advice on addAccount()");
//    }

//    @Before("execution(public void add*())")  // -> Matching any method starting with add...()
//    public void beforeAddAccountAdvice(){
//        System.out.println(getClass() + " =====>>>> Executing @Before advice on addAccount()");
//    }

//    @Before("execution(* add*())")  // -> Matching any return type
//    public void beforeAddAccountAdvice() {
//        System.out.println(getClass() + " =====>>>> Executing @Before advice on addAccount()");
//    }

//    @Before("execution(* add*(com.company.aopdemo.Account))")  // -> Matching on specific single parameter class (need to be fully qualified name)
//    public void beforeAddAccountAdvice() {
//        System.out.println(getClass() + " =====>>>> Executing @Before advice on addAccount()");
//    }

//    @Before("execution(* add*(com.company.aopdemo.Account, ..))") // -> Matching account first and then any type of other parameters
//    public void beforeAddAccountAdvice() {
//        System.out.println(getClass() + " =====>>>> Executing @Before advice on addAccount()");
//    }

//    @Before("execution(* add*(..))") // -> Matching any parameters
//    public void beforeAddAccountAdvice() {
//        System.out.println(getClass() + " =====>>>> Executing @Before advice on addAccount()");
//    }


    @Before("execution(* com.company.aopdemo.dao.*.*(..))") // -> Match methods in package
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>>> Executing @Before advice on addAccount()");
    }

}
