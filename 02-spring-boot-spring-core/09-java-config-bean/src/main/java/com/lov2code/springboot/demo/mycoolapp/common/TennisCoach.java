package com.lov2code.springboot.demo.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach() {
        System.out.println("In contructor: "+getClass().getName());
    }
    @Override
    public String getDailyWorkOut() {
        return "practice hiiting back volley";
    }

}
