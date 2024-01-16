package com.example.spring_study_hw2.controller;

import com.example.spring_study_hw2.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class MainController {
    private List<User> users = new ArrayList<>();

    @ResponseBody
    @PostMapping("/login")
    public Object login(User loginUser) {
        Boolean loginCheck = users.stream()
                .anyMatch(user -> user.id().equals(loginUser.id()) && user.password().equals(loginUser.password()));

        Map<String, Object> map = new HashMap<>();
        map.put("result", loginCheck);
        return map;
    }

    @PostMapping("/id-duplication-check")
    @ResponseBody
    public Object isNotIdDuplication(@RequestBody String id) {
        Map<String, Object> map = new HashMap<>();
        Boolean idCheck = users.stream()
                .anyMatch(user -> user.id().equals(id));
        if(!idCheck) { //db에 id가 없다.us
            System.out.println("id를 사용가능합니다.");
            map.put("result", true);
        } else {
            System.out.println("id가 중복되었습니다.");
            map.put("result", false);
        }
        return map;
    }

    @PostMapping("/signup")
    public String signup(User user) {
        users.add(user);
        System.out.println("이거 맞니");
        return "login";
    }

    @PostMapping("/users")
    @ResponseBody
    public Object users() {
        Map<String, Object> map = new HashMap<>();

        List<String> userNames = users.stream()
                .map(user -> user.id())
                .collect(Collectors.toList());

        map.put("userNames", userNames);

        return map;
    }

}
