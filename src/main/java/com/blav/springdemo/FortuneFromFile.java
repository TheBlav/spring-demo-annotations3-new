package com.blav.springdemo;

import org.springframework.stereotype.Component;

import javax.xml.catalog.Catalog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FortuneFromFile implements FortuneService{
    private String fileName = "/Users/mdziuba/IdeaProjects/spring-demo-annotations3/src/main/resources/fortunes.txt";
    private List<String> fortuneList;
    Random random = new Random();
    public FortuneFromFile(){
    try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
        fortuneList = new ArrayList<>();
        String tempLine;
        while ((tempLine = br.readLine()) != null){
            fortuneList.add(tempLine);
        }
    }
    catch (IOException e){
        System.err.println("File not found");
    }
    }
    @Override
    public String getFortune() {
        return fortuneList.get(random.nextInt(fortuneList.size()));
    }
}
