package com.spring.springcore.restcontroller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CoachController {

    private final Coach mycoach;
    @Autowired
    private CoachController(Coach Tcoach) {
        mycoach = Tcoach;
    }

    public static CoachController
        createCoachController(Coach Tcoach) {
        return new CoachController(Tcoach);
    }
    @GetMapping("/")
    public String home()
    {
        return "Hi Dude";
    }

    @GetMapping("/daily")
    public String getDailyWorkout()
    {
        return mycoach.getDailyWorkout();
    }
}
