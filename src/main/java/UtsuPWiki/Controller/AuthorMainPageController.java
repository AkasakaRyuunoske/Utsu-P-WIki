package UtsuPWiki.Controller;

import UtsuPWiki.utilities.Navigation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AuthorMainPageController {
    @GetMapping("/authors")
    public String authorsGETController(Model model){
        Navigation.addLocations(model, "home/authors");

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
