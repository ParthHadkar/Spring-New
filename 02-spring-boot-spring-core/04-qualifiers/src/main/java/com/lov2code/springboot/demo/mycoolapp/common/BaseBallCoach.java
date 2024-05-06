package com.lov2code.springboot.demo.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "Practing hitting home run";
    }
}
