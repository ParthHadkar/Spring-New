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

    @Override
    public String getDailyWorkOut() {
        return "Practice balling at 150km";
    }
}
