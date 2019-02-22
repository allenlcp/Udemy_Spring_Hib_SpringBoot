package com.company.aopdemo.aspect;

import com.company.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @AfterReturning(
                pointcut = "execution(* com.company.aopdemo.dao.AccountDAO.findAccounts(..))",
                returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> Executing @AfterReturning on method: " + method);

        // print out results of the method call
        System.out.println("\n=====>>>> result is: " + result);

        // let's post-process teh data... let's modify it

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
