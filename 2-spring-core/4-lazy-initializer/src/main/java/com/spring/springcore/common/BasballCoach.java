package com.spring.springcore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component

public class BasballCoach implements Coach {
    private Coach coach;

    public BasballCoach() {
        System.out.println("in out"+getClass().getSimpleName());}
    @Override
    public String getDailyWorkout() {
        return "Basebal workout 10 mins";
    }

    @Override
    public String getDailyFortune() {
        return "";
    }

}
