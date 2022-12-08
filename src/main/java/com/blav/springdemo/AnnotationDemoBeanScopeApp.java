package com.blav.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoBeanScopeApp {
    public static void main(String[] args) {
        // load spring config file
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext
                ("applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

//        check if those beans are the same
        System.out.println(theCoach==alphaCoach);
        System.out.println("theCoach memory location: " + theCoach);
        System.out.println("alphaCoach memory location: " + alphaCoach);


        context.close();
    }
}
