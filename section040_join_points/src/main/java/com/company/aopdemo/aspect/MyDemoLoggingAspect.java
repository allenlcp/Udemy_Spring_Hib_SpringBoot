package com.company.aopdemo.aspect;

import com.company.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

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
