package com.company.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.company.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.company.aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.company.aopdemo.dao.*.set*(..))")
    public void setter(){}

    // Include package ... exclude getter and setter methods
    @Pointcut("forDaoPackage() && !(getter() || setter())") // -> Referencing multiple pointcut - similar to if evaluation
    public void forDaoPackageNoGetterSetter() {}

//    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//    Multiple advice referencing similar pointcut
//    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//    @Before("forDaoPackage()") // -> Referencing pointcut
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=====>>>> Executing @Before advice on addAccount()");
//    }
//
//    @Before("forDaoPackage()") // -> Referencing pointcut
//    public void performApiAnalytics() {
//        System.out.println("\n=====>>>> Performing API analytics");
//    }
//    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


//    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//    Advice referencing a pointcut that has joined pointcut
//    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Before("forDaoPackageNoGetterSetter()") // -> Referencing pointcut
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>>> Executing @Before advice on addAccount()");
    }
//    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}
