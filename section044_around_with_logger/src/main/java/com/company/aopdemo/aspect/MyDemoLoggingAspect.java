package com.company.aopdemo.aspect;

import com.company.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.company.aopdemo.service.*.getFortune(..))")
    public Object aroundFindAccountsAdvice(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
        // print out which method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // execute the method
        Object result = theProceedingJoinPoint.proceed();

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        myLogger.info("\n=====>>>> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.company.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>>> Executing @After (finally) on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.company.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>>> Executing @AfterThrowing on method: " + method);

        // log exception
        myLogger.info("\n=====>>>> The exception is: " + theExc);
    }

    @AfterReturning(
                pointcut = "execution(* com.company.aopdemo.dao.AccountDAO.findAccounts(..))",
                returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>>> Executing @AfterReturning on method: " + method);

        // print out results of the method call
        myLogger.info("\n=====>>>> result is: " + result);

        // let's post-process the data... let's modify it

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        myLogger.info("\n====>>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for(Account tempAccount : result) {
            tempAccount.setName(tempAccount.getName().toUpperCase());
        }
    }


    @Before("com.company.aopdemo.aspect.AopExpressionsHelper.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        myLogger.info("\n=====>>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        myLogger.info("Method sig::: " + methodSig);

        // display the method arguments
        Object[] args = theJoinPoint.getArgs();

        for(Object tempObj : args){
            myLogger.info(tempObj.toString());

            if (tempObj instanceof Account){
                // downcast and print
                myLogger.info(((Account)tempObj).getName());
                myLogger.info(((Account)tempObj).getLevel());
            }
        }

    }

}
