package com.lov2code.springboot.demo.mycoolapp.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("In contructor: "+getClass().getSimpleName());
    }

    // define our init method
    @PostConstruct
    public void doMyStartupSuff() {
        System.out.println("In doMyStartupSuff(): "+getClass().getSimpleName());
    }
    // define our destroy method
    @PreDestroy
    public void doMyCleanupSuff() {
        System.out.println("In doMyCleanupSuff(): "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkOut() {
        return "Practice balling at 150km";
    }
}
