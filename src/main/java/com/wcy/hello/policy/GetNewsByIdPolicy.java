package com.wcy.hello.policy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wcy.hello.model.elasticsearch.News;
import com.wcy.hello.repository.elasticsearch.EsNewsRepo;
import com.wcy.hello.service.elasticsearch.EsNewsService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class GetNewsByIdPolicy {

    @Autowired
    private EsNewsService esNewsService;

    public String getMethodName() {
        return "GetNewsByIdPolicy";
    }
    @Around("execution(* com.wcy.hello.repository.mongo.NewsRepo.findById(..))")
    public Object getNewsByIdHook(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("Before invoking getName() method");
        Object value = null;
        String jsonInString = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.out.println("After invoking getName() method");
        try {
            Method method = value.getClass().getMethod("get", new Class[]{});
            Object news = method.invoke(value);
            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writeValueAsString(news);
            System.out.println("After Return value="+jsonInString);
            News esNews = mapper.readValue(jsonInString, News.class);
            esNewsService.save(esNews);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
