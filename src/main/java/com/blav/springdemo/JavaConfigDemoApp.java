package com.blav.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        // load spring config class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext
                        (SportConfig.class);

        // retrieve bean from spring container
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);


//        check if those beans are the same
        System.out.println("theCoach memory location: " + theCoach);
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        theCoach.printData();

        // close Spring container
        context.close();
    }
}
