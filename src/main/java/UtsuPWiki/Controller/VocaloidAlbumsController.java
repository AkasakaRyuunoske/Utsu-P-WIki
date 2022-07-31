package UtsuPWiki.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VocaloidAlbumsController {
    @GetMapping("/authors/{author}/albums")
    public String albumsGETController(Model model, @PathVariable String author){
        model.addAttribute("currentPage","/authors/{author}/albums");
        return "albums";
    }

    @GetMapping("/authors/{author}/albums/{album}")
    public String albumGETController(Model model, @PathVariable String author, @PathVariable String album){
        model.addAttribute("currentPage","/authors/{author}/albums/{album}");
        return album;
    }
}
