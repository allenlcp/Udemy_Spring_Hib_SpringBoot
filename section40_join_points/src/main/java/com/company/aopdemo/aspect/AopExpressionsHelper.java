package com.company.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressionsHelper {
    @Pointcut("execution(* com.company.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.company.aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.company.aopdemo.dao.*.set*(..))")
    public void setter(){}

    // Include package ... exclude getter and setter methods
    @Pointcut("forDaoPackage() && !(getter() || setter())") // -> Referencing multiple pointcut - similar to if evaluation
    public void forDaoPackageNoGetterSetter() {}
}
