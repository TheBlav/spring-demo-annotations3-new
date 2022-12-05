package com.blav.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {
        // read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext
                        ("applicationContext.xml");

        // get bean from container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        // call methods on bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        SwimCoach coach2 = context.getBean("swimCoach", SwimCoach.class);
        System.out.println("\n" + coach2.getDailyFortune());
        System.out.println(coach2.getDailyWorkout());
        System.out.println("email: " + coach2.getEmail());
        System.out.println("Team: " + coach2.getTeam());


        //close container
        context.close();
    }
}
