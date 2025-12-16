package com.spring.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class CricketCoachs implements Coach {


    private Coach mycoach;

    public CricketCoachs() {
    System.out.println("in out"+getClass().getSimpleName());}
    @Override
    public String getDailyWorkout() {

        return "do jump for 5 mins.....";
    }

    @Override
    public String getDailyFortune() {
        return "";
    }
}
