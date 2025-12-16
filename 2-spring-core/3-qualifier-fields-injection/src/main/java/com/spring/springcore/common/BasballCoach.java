package com.spring.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class BasballCoach implements Coach {
    private Coach coach;


    @Override
    public String getDailyWorkout() {
        return "Basebal workout 10 mins";
    }

    @Override
    public String getDailyFortune() {
        return "";
    }

}
