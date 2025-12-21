package com.adley.springboot.MVC.COntroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class HelloWorldControllle {

    @RequestMapping("/showform")
    public String showForm(Model model) {
        return "HelloWorld-form";
    }
    @RequestMapping("/process")
    public String process(@RequestParam("studentName") String Name, Model model) {
       String theName;     //=request.getParameter("studentName");
      theName=Name.toLowerCase();

       String result="Your name is "+theName;
       model.addAttribute("message",result);
     return "hello";
    }
}
