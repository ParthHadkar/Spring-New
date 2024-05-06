package com.luv2code.aopdemo.service;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{
    @Override
    public String getFortune() {
        try{
            Thread.sleep(5000);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        return "Expect heavy traffic this morning";
    }

    @Override
    public String getFortune(boolean pTripeWire) {
        if(pTripeWire){
            throw new RuntimeException("Major accident! Highway is closed!!!!");
        }
        return getFortune();
    }
}
