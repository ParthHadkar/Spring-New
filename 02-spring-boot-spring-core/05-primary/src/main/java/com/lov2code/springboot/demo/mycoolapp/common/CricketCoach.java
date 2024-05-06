package com.lov2code.springboot.demo.mycoolapp.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "Practice balling at 150km";
    }
}
