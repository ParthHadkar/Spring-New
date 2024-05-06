package com.lov2code.springboot.demo.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
    public BaseBallCoach() {
        System.out.println("In contructor: "+getClass().getName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Practing hitting home run";
    }
}
