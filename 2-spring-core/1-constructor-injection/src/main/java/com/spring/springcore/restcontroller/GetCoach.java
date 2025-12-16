package com.spring.springcore.restcontroller;

import org.springframework.stereotype.Component;

@Component
public class GetCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "do jump for 15 mins.....";
    }

    @Override
    public String getDailyFortune() {
        return "check health";
    }
}
