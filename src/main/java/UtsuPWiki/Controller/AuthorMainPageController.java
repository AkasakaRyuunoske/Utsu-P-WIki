package UtsuPWiki.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AuthorMainPageController {
    @GetMapping("/authors")
    public String authorsGETController(Model model){
        model.addAttribute("homePage","home/");
        model.addAttribute("authorsPage","authors/");
        return "authors";
    }

    @GetMapping("/authors/{author}")
    public String authorGETController(@PathVariable String author, Model model){
        model.addAttribute("author","utsu-p");
        model.addAttribute("authorsPage","authors/{author}");
        return "authors";
    }
}
