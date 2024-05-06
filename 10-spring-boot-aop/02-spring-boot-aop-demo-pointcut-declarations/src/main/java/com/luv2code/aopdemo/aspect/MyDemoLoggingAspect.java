package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.model.Account;
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

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortuneAdvice(ProceedingJoinPoint pProceedingJoinPoint) throws Throwable{
        String lMethod = pProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @Around on method: "+lMethod);

        long begin = System.currentTimeMillis();

        Object lResult = null;

        try {
            lResult = pProceedingJoinPoint.proceed();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            lResult = "Major accident! But no worries, your private AOP helicoper is on the way!";

            throw e;
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("\n====> Duration:: "+ (duration / 1000.0) +" seconds");

        return lResult;
    }
    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint pJoinPoint){
        String lMethod = pJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @After (finally) on method: "+lMethod);
    }
    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "pExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint pJoinPoint, Throwable pExc){
        String lMethod = pJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @AfterThrowing on method: "+lMethod);
        System.out.println("\n====> Exception: "+pExc);
    }

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "pResults"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint pJoinPoint, List<Account> pResults){
        String lMethod = pJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @AfterReturning on method: "+lMethod);
        System.out.println("\n====> pResults: "+pResults);

        covertAccountNameToUpperCase(pResults);

        System.out.println("\n====> pResults: "+pResults);
    }

    private void covertAccountNameToUpperCase(List<Account> pResults) {
        for(Account lAccount : pResults){
            String lName = lAccount.getName().toUpperCase();
            lAccount.setName(lName);
        }
    }
    // this is where we right all our related advices for logging
    // let start with @Before Advice



    //@Before("execution(public void addAccount())")
    //@Before("execution(public void updateAccount())")
    //@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
    //@Before("execution(public void add*())")
    //@Before("execution(void add*())")
    //@Before("execution(* add*())")
    //@Before("execution(* add*(com.luv2code.aopdemo.model.Account))")
    //@Before("execution(* add*(Account))")
    //@Before("execution(* add*(com.luv2code.aopdemo.model.Account, *))")
    //@Before("execution(* add*(com.luv2code.aopdemo.model.Account, ..))")
    //@Before("execution(* add*(..))")
    //@Before("forDAOPackage()")
    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint pJoinPoint){
        System.out.println("\n=====>>>> Executing @Before advice on method()");

        MethodSignature lMethodSignature = (MethodSignature) pJoinPoint.getSignature();

        System.out.println("lMethodSignature :: "+lMethodSignature);

        Object[] lArgs = pJoinPoint.getArgs();
        for(Object lTempArg : lArgs){
            System.out.println("tempArg :: "+lTempArg);
            if(lTempArg instanceof Account){
                Account lAccount = (Account) lTempArg;
                System.out.println("account name :: "+lAccount.getName());
                System.out.println("account level :: "+lAccount.getLevel());
            }
        }
    }

}
