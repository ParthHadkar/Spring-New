package com.lov2code.springboot.demo.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "Practice balling at 150km";
    }
}
