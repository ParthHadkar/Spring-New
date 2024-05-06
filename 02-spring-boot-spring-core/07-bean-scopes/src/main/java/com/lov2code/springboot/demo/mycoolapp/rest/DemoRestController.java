package com.lov2code.springboot.demo.mycoolapp.rest;

import com.lov2code.springboot.demo.mycoolapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    private Coach coach;
    private Coach anotherCoach;

    @Autowired
    public DemoRestController(@Qualifier("cricketCoach") Coach coach, @Qualifier("cricketCoach") Coach anotherCoach){
        System.out.println("In contructor: "+getClass().getName());
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return coach.getDailyWorkOut();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: coach == anotherCoach, "+(coach == anotherCoach);
    }
}
