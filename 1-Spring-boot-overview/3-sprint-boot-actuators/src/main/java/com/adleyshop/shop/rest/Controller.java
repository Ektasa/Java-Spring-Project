package com.adleyshop.shop.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Value("${app.name}")
    private String appName;
    @GetMapping("/")
    public String hello()
    {
        return "Hello! "+appName;
    }

    @GetMapping( "/run")
    public String run()
    {
        return "HelloWallet Whose hoow Run";
    }
}
