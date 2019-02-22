package com.company.aopdemo.aspect;

import com.company.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


    @Around("execution(* com.company.aopdemo.service.*.getFortune(..))")
    public Object aroundFindAccountsAdvice(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
        // print out which method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // execute the method
        Object result = theProceedingJoinPoint.proceed();

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n=====>>>> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.company.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> Executing @After (finally) on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.company.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> Executing @AfterThrowing on method: " + method);

        // log exception
        System.out.println("\n=====>>>> The exception is: " + theExc);
    }

    @AfterReturning(
                pointcut = "execution(* com.company.aopdemo.dao.AccountDAO.findAccounts(..))",
                returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> Executing @AfterReturning on method: " + method);

        // print out results of the method call
        System.out.println("\n=====>>>> result is: " + result);

        // let's post-process the data... let's modify it

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n====>>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for(Account tempAccount : result) {
            tempAccount.setName(tempAccount.getName().toUpperCase());
        }
    }


    @Before("com.company.aopdemo.aspect.AopExpressionsHelper.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method sig::: " + methodSig);

        // display the method arguments
        Object[] args = theJoinPoint.getArgs();

        for(Object tempObj : args){
            System.out.println(tempObj);

            if (tempObj instanceof Account){
                // downcast and print
                System.out.println(((Account)tempObj).getName());
                System.out.println(((Account)tempObj).getLevel());
            }
        }

    }

}
