package com.blav.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach{
    @Value("${foo.email}")
    private String email;
    @Value("${foo.team}")
    private String team;

    public String getEmail(){
        return email;
    }

    public String getTeam(){
        return team;
    }
    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "swim 2k on your back";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }



}
