package UtsuPWiki.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class HomePageController {
    @GetMapping("/")
    String indexController(Model model){
        log.info("indexController Was called!");

        model.addAttribute("homePage","home/");
        model.addAttribute("authorsPage","authors/");

        return "index";
    }
}
