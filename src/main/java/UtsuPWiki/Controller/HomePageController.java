package UtsuPWiki.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class HomePageController {
    @GetMapping("/")
    String indexController(Model model){
        log.info("Was called!");
        model.addAttribute("message","<h1>Utsu-P  --  The Dying Message</h1>");
        return "huindex";
    }

    @GetMapping("/test")
    String indexControllerTEST(Model model){
        log.info("Was called!");
        model.addAttribute("message","<h1>Utsu-P  --  The Dying Message</h1>");
        return "index";
    }

    @PostMapping("/")
    String POSTindexController(Model model){
        log.info("Was called!");
        model.addAttribute("message","<h1>Utsu-P  --  The Dying Message</h1>");
        return "index";
    }
}
