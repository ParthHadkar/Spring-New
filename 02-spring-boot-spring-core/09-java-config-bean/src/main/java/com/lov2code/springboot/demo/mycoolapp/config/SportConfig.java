package com.lov2code.springboot.demo.mycoolapp.config;

import com.lov2code.springboot.demo.mycoolapp.common.Coach;
import com.lov2code.springboot.demo.mycoolapp.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("acquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }

}
