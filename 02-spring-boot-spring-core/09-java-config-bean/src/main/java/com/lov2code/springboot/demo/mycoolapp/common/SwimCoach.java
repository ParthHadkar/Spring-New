package com.lov2code.springboot.demo.mycoolapp.common;

public class SwimCoach implements Coach{
    public SwimCoach() {
        System.out.println("In contructor: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "swim 1000 meters as warm up";
    }
}
