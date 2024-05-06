package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppflow(){}

    @Before("forAppflow()")
    public void before(JoinPoint pJoinPoint){
        String lMethod = pJoinPoint.getSignature().toShortString();
        logger.info("====> in @Before: calling method: "+lMethod);

        Object[] lArgs = pJoinPoint.getArgs();

        for(Object lArg : lArgs){
            logger.info("====> argument: "+lArg);
        }
    }

    @AfterReturning(
            pointcut = "forAppflow()",
            returning = "pResult"
    )
    public void afterReturning(JoinPoint pJoinPoint,Object pResult){
        String lMethod = pJoinPoint.getSignature().toShortString();
        logger.info("====> in @AfterReturning: calling method: "+lMethod);

        logger.info("====> result: "+pResult);
    }

}
