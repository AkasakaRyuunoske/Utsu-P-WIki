package Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class HomePageController {
    @GetMapping("/")
    String indexController(){
        log.info("Was called!");
        return "index";
    }
}
