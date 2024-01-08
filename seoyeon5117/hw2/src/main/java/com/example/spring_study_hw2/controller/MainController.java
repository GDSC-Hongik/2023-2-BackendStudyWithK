package com.example.spring_study_hw2.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// 이 부분에 어떤 애노테이션?
@RestController
@RequestMapping("/main")
public class MainController {

    // post 방식으로 textDTO가 리턴되도록 구현한다.
    //post request의 body 부분은 { text : "내용" } 이 담겨있다.
    @PostMapping("/text")
    public Object text1(HttpServletRequest request) {
        String text = request.getParameter("text");
        TextDTO textDTO = new TextDTO(text);
        return textDTO;
    }

    //get 방식으로 textDTO가 리턴되도록 구현한다.
    //get uri는 GET /text?text=내용
    @GetMapping("/text/{text}")
    public Object text2(@PathVariable("text") String text) {
        TextDTO textDTO = new TextDTO(text);
        return textDTO;
    }
}
