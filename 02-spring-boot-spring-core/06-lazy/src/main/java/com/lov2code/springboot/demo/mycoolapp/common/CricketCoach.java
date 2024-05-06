package com.lov2code.springboot.demo.mycoolapp.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("In contructor: "+getClass().getName());
    }
    @Override
    public String getDailyWorkOut() {
        return "Practice balling at 150km";
    }
}
