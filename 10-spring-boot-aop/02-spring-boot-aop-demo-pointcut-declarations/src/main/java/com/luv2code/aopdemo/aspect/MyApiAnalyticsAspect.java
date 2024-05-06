package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
    public MyApiAnalyticsAspect() {
    }

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDAOPackageNoGetterSetter()")
    public void performApiAnalyticsAdvice() {
        System.out.println("\n=====>>>> performing Api Analytics");
    }
}