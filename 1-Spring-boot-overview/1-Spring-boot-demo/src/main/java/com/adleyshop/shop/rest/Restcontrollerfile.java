package com.adleyshop.shop.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Restcontrollerfile {
 @GetMapping("/")
         public String hello()
 {
     return "Hello World!";
 }
}
