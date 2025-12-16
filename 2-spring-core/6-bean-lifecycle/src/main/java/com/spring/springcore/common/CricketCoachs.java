package com.spring.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoachs implements Coach {


    private Coach mycoach;

    public CricketCoachs() {
    System.out.println("in out"+getClass().getSimpleName());}

    //postcontruct prototype bean
    @PostConstruct
            public void poststuff()
    {
        System.out.println("poststuff "+getClass().getSimpleName());}

    //destro stuff
@PreDestroy
public void cleanupstuff()
{
    System.out.println("clean up stuff"+getClass().getSimpleName());
}


    @Override
    public String getDailyWorkout() {

        return "do jump for 5 mins.....";
    }

    @Override
    public String getDailyFortune() {
        return "";
    }
}
