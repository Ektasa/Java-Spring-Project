package com.spring.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoachs implements Coach {


    private Coach mycoach;

    @Override
    public String getDailyWorkout() {

        return "do jump for 5 mins.....";
    }

    @Override
    public String getDailyFortune() {
        return "";
    }
}
