package com.example.signupbackend.controller;

import org.springframework.web.bind.annotation.*;
import com.example.signupbackend.model.SignupRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest req) {
        // TODO: persist user, hash password, validate, etc.
        return "User registered with email: " + req.getEmail();
    }
}
