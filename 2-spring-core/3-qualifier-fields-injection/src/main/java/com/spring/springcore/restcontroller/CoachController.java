package com.spring.springcore.restcontroller;

import com.spring.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CoachController {

    private Coach mycoach;
    //private Coach mycoach;
    @Autowired
    //qualifier means to get extcat coach
//    public CoachController(@Qualifier("basballCoach") Coach tcoach) {
//        mycoach = tcoach;
//    }
    public CoachController(Coach tcoach) {
        mycoach = tcoach;
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
