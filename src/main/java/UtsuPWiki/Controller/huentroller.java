package UtsuPWiki.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class huentroller {
    @GetMapping("/mawaru")
    String huentroller1(){
        System.out.println("Was called!");
        return "huindex";
    }
}
