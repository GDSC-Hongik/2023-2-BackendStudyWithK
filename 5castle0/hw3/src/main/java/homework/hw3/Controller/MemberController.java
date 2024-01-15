package homework.hw3.Controller;

import homework.hw3.Member;
import homework.hw3.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class MemberController {

    private final Service service;

    @Autowired
    public MemberController(Service service){this.service=service;}

    @GetMapping("/members/new")
    public String createFrom(){return "members/createMemberForm";}

    @PostMapping("/members/new")
    //@ResponseBody
    //public String create(MemberForm form){
    public String create(@RequestParam("id") String id,@RequestParam("pw") String pw){
        Member member = new Member(id,pw);


        service.join(member);

        return "redirect:/";
    }

    @PostMapping("/members")
    public String login(@RequestParam("id")String id,@RequestParam("pw") String pw){
        String loginResult = service.login(id,pw);

        if(loginResult.equals("success")){
            return "/members/loginSuccess";
        } else if (loginResult.equals("loginFail")) {
            return "/members/loginFail";
        }
        return "/members/noExist";
    }





}
