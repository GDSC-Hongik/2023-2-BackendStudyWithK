package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 홈 화면 추가 (단순히 회원 등록하고 조회할 수 있는 버튼 링크가 있는 사이트)
@Controller
public class HomeController {

    @GetMapping("/") //local8080을 들어가면 이 부분이 호출됨
    public String home(){
        return "home";
    }

}
