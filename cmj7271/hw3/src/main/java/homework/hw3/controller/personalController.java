package homework.hw3.controller;

import homework.hw3.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class personalController {

    private final MemberService memberService;

    public personalController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/{id}")
    public String personal(@PathVariable("id") String id,
                           @RequestParam(name = "status") boolean status,
                           Model model) {
        if(status) {
            model.addAttribute("Info", memberService.getInfo(id));
            return "personal/personal";
        }

        return "redirect:/";
    }
}
