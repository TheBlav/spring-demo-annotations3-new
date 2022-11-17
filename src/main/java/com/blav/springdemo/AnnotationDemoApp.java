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
        //close container
        context.close();
    }
}
