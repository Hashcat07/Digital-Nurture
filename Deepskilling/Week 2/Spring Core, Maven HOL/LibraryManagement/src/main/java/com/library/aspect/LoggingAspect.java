package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {

//    @Around("execution(* com.library.service.*.*(..))")
//    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//        long start = System.currentTimeMillis();
//
//        Object result = joinPoint.proceed();
//
//        long elapsed = System.currentTimeMillis() - start;
//        System.out.println("[AOP] " + joinPoint.getSignature() + " ran in " + elapsed + " ms");
//        return result;
//    }
    @Before("execution(* com.library.service.*.*(..))")
        public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("[BEFORE] calling " + joinPoint.getSignature().getName());
}

    @After("execution(* com.library.service.*.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("[AFTER]  finished " + joinPoint.getSignature().getName());
    }
}