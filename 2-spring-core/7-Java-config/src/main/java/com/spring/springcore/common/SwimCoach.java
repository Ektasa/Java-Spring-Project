package com.spring.springcore.common;

import org.springframework.stereotype.Component;

//@Component
public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("in swim "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "SWim for 400m";
    }

    @Override
    public String getDailyFortune()
    {
        return "Swim Coach";
    }



}
