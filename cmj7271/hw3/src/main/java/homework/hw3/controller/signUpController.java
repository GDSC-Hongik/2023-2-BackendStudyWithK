package homework.hw3.controller;

import homework.hw3.domain.Member;
import homework.hw3.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class signUpController {

    private final MemberService memberService;

    public signUpController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members/sign-up")
    public String movePage() { return "signUp/signUp"; }

    @PostMapping("/members")
    public String signUp(@RequestParam(name = "id") String id,
                         @RequestParam(name = "pw") String pw,
                         @RequestParam(name = "pw_check") String pw_check) {
        if(! pw.equals(pw_check)) return "redirect:/signUp/sign-up";

        Member member = new Member();
        member.setId(id);
        member.setPw(pw);

        if(! memberService.signUp(member)) return "redirect:/signUp/sign-up";

        System.out.println("signUp succeed");

        return "redirect:/";
    }
}
