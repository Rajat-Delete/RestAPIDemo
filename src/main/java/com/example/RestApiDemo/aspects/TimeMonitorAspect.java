package com.example.RestApiDemo.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {


    @Around("@annotation(TimeMonitor)")
    public Object calculateTime(ProceedingJoinPoint joinPoint) {
        System.out.println("started logging in Time");
        long startTime = System.currentTimeMillis();
        Object obj = null;
        try {
            obj = joinPoint.proceed();
//            System.out.println("obj is "+obj);
        } catch (Throwable e) {
            System.out.println(e.getStackTrace());
        } finally {
            long endTime = System.currentTimeMillis();

            long timeTaken = endTime - startTime;
            System.out.println("The Time Taken for get Employee By Id Api is " + timeTaken + " ms...");
            
        }
        //now we will run our business logic
        return obj;

    }

}
