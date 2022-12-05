package com.blav.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{
    private String[] fortunes = {
                        "Today is your lucky day!",
                        "get a good one!",
                        "You're gonna get it today!",
                        "You should move on!"};
    private Random random = new Random();
    @Override
    public String getFortune() {
        return fortunes[random.nextInt(fortunes.length)];
    }
}
