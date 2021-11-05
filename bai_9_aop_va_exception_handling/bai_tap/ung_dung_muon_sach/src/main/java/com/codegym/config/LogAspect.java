package com.codegym.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.codegym.controller.BookController.save*(..))")
    public void allMethodChangePointCut(){}
    @Pointcut("within(com.codegym.controller.BookController*)")
    public void allMethodPointCut(){}
    @Around("allMethodChangePointCut()")
    public Object aroundAllMethodChange(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("Before library change time: " + LocalDateTime.now());
        Object value = null;
        try{
            value = proceedingJoinPoint.proceed();
        }catch (Throwable throwable){
            System.out.println("Throwing library change time: " + LocalDateTime.now());
            throwable.printStackTrace();
        }
        System.out.println("End library change time: " + LocalDateTime.now() + "Return value = " + value);
        return value;
    }
    @Around("allMethodPointCut()")
    public Object aroundAllMethod(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("Before method time: " + LocalDateTime.now());
        Object value = null;
        try{
            value = proceedingJoinPoint.proceed();
        }catch (Throwable throwable){
            System.out.println("Throwing method time: " + LocalDateTime.now());
            throwable.printStackTrace();
        }
        System.out.println("End method time: " + LocalDateTime.now() + "Return value = " + value);
        return value;
    }
}
