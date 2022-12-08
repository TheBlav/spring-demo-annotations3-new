package com.blav.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach  implements Coach{

    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("startup stuff");
    }
    @PreDestroy
    public void doMyDestructionStuff(){
        System.out.println("Closing stuff");
    }
    private FortuneService fortuneService;

    @Autowired
    public TennisCoach (
                            @Qualifier("randomFortuneService")
                            FortuneService fortuneService )
    {
        this.fortuneService = fortuneService;
        System.out.println(">>Inside default constructor");
    }


    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
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
