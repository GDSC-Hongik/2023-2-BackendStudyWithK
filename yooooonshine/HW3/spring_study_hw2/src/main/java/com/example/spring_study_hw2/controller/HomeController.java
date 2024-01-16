package com.example.spring_study_hw2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
}
