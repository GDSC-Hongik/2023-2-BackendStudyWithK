package hw2.homework;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
//    @GetMapping("by-get")
//    public String getMethod(@RequestParam(value = "content") String content, Model model) {
//        model.addAttribute("place", content);
//        return "home";
//    }

    @GetMapping("/")
    public String home() { return "home"; }
}
