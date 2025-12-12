package com.adleyshop.shop.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String hello()
    {
        return "Hello World!";
    }

    @GetMapping( "/run")
    public String run()
    {
        return "HelloWallet Whose hoow Run";
    }
}
