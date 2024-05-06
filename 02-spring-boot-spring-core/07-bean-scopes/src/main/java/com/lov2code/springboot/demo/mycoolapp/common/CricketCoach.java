package com.lov2code.springboot.demo.mycoolapp.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("In contructor: "+getClass().getName());
    }
    @Override
    public String getDailyWorkOut() {
        return "Practice balling at 150km";
    }
}
