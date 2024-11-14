package com.workintech.ecomm.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
@CrossOrigin(origins = "http://localhost:5173")
public class WelcomeController {

    @GetMapping("/")
    public String welcome(){
        return "Welcome";
    }
}
