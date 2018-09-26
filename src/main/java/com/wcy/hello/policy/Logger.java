package com.wcy.hello.policy;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class Logger {

    public String getMethodName() {
        return "Logger";
    }

    @Pointcut("execution(public * com.wcy.hello.repository..*.*(..))")
    public void repositoryLogger() {
    }

    @Before("repositoryLogger()")
    public void preRetrieve() {
        System.out.println(getMethodName() + " [Pre]" + new Date());
    }

    @After("repositoryLogger()")
    public void postRetrieve() {
        System.out.println(getMethodName() + " [Post]" + new Date());
    }
}
