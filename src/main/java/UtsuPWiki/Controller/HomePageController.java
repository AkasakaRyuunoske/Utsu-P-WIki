package UtsuPWiki.Controller;

import UtsuPWiki.utilities.Navigation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class HomePageController {
    @Autowired
    Navigation navigation;

    @GetMapping("/")
    String indexController(Model model){
        log.info("indexController Was called!");

        navigation.addLocations(model, "home/sanman/de/fuantei/na/kono");

        return "index";
    }
}
