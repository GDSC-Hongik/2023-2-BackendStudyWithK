package hw2.homework;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @GetMapping("page-by-get")
    public String goGet() { return "page_GET"; }

    @GetMapping("page-by-post")
    public String goPost() { return "page_POST"; }

    @PostMapping("write-something")
    public String postMethod(@RequestParam(value = "name") String content,  Model model) {
        model.addAttribute("place", content);
        return "home";
    }

    @GetMapping("write-something")
    public String getMethod(@RequestParam(value = "name") String content,  Model model) {
        model.addAttribute("place", content);
        return "home";
    }
}
