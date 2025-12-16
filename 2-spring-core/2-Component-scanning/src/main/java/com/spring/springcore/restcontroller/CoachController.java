package com.spring.springcore.restcontroller;

import com.spring.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CoachController {

    private Coach mycoach;
    @Autowired
    public void SetController(Coach Tcoach) {
        mycoach = Tcoach;
    }

//    public static CoachController
//        createCoachController(Coach Tcoach) {
//        return new CoachController(Tcoach);
//    }
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
