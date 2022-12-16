package com.blav.springdemo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class TennisCoach  implements Coach, DisposableBean {

    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("startup stuff");
    }
    @PreDestroy
    public void doMyCleanUpStuff(){
        System.out.println("CleanUp stuff");
    }


    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;



    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Inside Dstroy() method");
    }
//    public FortuneService getFortuneService() {
//        return fortuneService;
//    }
//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        System.out.println(">>isnide autowired setter");
//        this.fortuneService = fortuneService;
//    }
}
