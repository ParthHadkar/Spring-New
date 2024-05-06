package com.lov2code.springboot.demo.mycoolapp.rest;

import com.lov2code.springboot.demo.mycoolapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    private Coach coach;

    @Autowired
    public DemoRestController(@Qualifier("cricketCoach") Coach coach){
        System.out.println("In contructor: "+getClass().getName());
        this.coach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return coach.getDailyWorkOut();
    }

}
