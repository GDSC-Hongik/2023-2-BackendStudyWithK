package homework.hw3.controller;

import homework.hw3.domain.Member;
import homework.hw3.domain.MemberInfo;
import homework.hw3.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class homeController {

    private final MemberService memberService;

    public homeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home() { return "home/home"; }

    @PostMapping("/members/login")
    public String login(@RequestParam(name = "id") String id,
                        @RequestParam(name = "pw") String pw,
                        Model model,
                        RedirectAttributes redirectAttributes) {

        Member member = new Member();
        member.setId(id);
        member.setPw(pw);

        MemberInfo memberInfo = memberService.login(member);

        model.addAttribute("info", memberInfo);
        redirectAttributes.addAttribute("id", id);
        redirectAttributes.addAttribute("status", true);

        return "redirect:/members/{id}";
    }
}
