package UtsuPWiki.Controller;

import UtsuPWiki.utilities.Navigation;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller
public class VocaloidAlbumsController {
    @GetMapping("/authors/{author}/albums")
    public String albumsGETController(Model model, @PathVariable String author, HttpServletRequest request){
        Navigation.addLocations(model, request);

        String resultPage = "Authors/" + author + "/" + author + "Albums"; // here is defined page to be returned
        model.addAttribute("currentPage","/authors/{" + author + "}/albums");

        return resultPage;
    }

    @GetMapping("/authors/{author}/albums/{album}")
    public String albumGETController(Model model, @PathVariable String author, @PathVariable String album, HttpServletRequest request){
        Navigation.addLocations(model, request);

        String resultPage = "Authors/" + "/" + author + "/" + "Albums" + "/" + album + ".html"; // here is defined page to be returned
        model.addAttribute("currentPage","/authors/{" + author + "}/albums/{" + album + "}");

        return resultPage;
    }
}
