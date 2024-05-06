package com.lov2code.springboot.demo.mycoolapp.common;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    public TrackCoach() {
        System.out.println("In contructor: "+getClass().getName());
    }
    @Override
    public String getDailyWorkOut() {
        return "practice running hard 5k!";
    }

}
