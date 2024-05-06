package com.lov2code.springboot.demo.mycoolapp.common;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "practice running hard 5k!";
    }

}
