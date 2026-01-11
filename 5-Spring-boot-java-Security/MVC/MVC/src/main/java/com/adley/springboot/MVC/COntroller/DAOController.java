package com.adley.springboot.MVC.COntroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DAOController {

    @GetMapping("/hello")
            public String sayhello(Model model)
    {
        model.addAttribute("message", "Hello Spring MVC");
        return "hello";
    }
}
