package com.example.spring_study_hw2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    //이 부분에 localhost:8080 으로 들어갔을 때 main.html 이 response 되도록 구현
    @GetMapping("/")
    public String text() {
        return "main";
    }
}
