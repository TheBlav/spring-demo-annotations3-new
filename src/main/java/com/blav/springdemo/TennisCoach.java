package com.blav.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach  implements Coach{
//    @Autowired
//    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    @Autowired
    public TennisCoach (
                            @Qualifier("randomFortuneService")
                            FortuneService fortuneService )
    {
        this.fortuneService = fortuneService;
        System.out.println(">>Inside default constructor");
    }
    /*
    @Autowired
    public void doSomeCreazyStuff(FortuneService fortuneService){
        this.fortuneService=fortuneService;
    }
     */

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
