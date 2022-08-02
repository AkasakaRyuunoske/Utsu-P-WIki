package UtsuPWiki.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Log4j2
@Controller
public class VocaloidAlbumsController {
    @GetMapping("/authors/{author}/albums")
    public String albumsGETController(Model model, @PathVariable String author){
        String resultPage = "Authors/" + author + "/" + author + "-albums"; // here is defined page to be returned
        model.addAttribute("currentPage","/authors/{" + author + "}/albums");
        return resultPage;
    }

    @GetMapping("/authors/{author}/albums/{album}")
    public String albumGETController(Model model, @PathVariable String author, @PathVariable String album){
        String resultPage = "Authors/" + author + "/" + author + "-albums"; // here is defined page to be returned
        model.addAttribute("currentPage","/authors/{" + author + "}/albums/{" + album + "}");
        return album;
    }
}
