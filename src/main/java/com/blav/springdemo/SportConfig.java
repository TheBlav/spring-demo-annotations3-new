package com.blav.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.blav.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
    // Bean for Coach
    @Bean
    public Coach swimCoach(){
        SwimCoach mySwimCoach = new SwimCoach(randomFortuneService());
        return mySwimCoach;
    }
    // Bean for FortuneService
    @Bean
    public FortuneService randomFortuneService(){
        return new FortuneFromFile();
    }
}
