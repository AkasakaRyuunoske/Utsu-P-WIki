package UtsuPWiki.Controller;

import UtsuPWiki.utilities.Navigation;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Log4j2
@Controller
public class AuthorMainPageController {
    @GetMapping("/authors")
    public String authorsGETController(Model model){
        Navigation.addLocations(model, "home/authors");
        log.info("Was called!");

        return "authors";
    }

    @GetMapping("/authors/{type}/{author}")
    public String authorGETController(@PathVariable String author,
                                      @PathVariable String type,
                                      Model model){
        Navigation.addLocations(model, "home/authors/" + type + "/" + author + "/");

        return author;
    }
}
