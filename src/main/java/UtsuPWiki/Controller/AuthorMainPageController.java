package UtsuPWiki.Controller;

import UtsuPWiki.Repository.AuthorsRepository;
import UtsuPWiki.utilities.Navigation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

/**
 * Is responsive for returning Authors related pages.
 *
 * currently does:
 *
 * GET : /authors                   (soon will be deprecated, remains for compatibility)
 * GET : /types/authors             Returns ALL authors that are available in db
 * GET : /{type}/authors            Returns all authors that have that TYPE as main_type(fk)
 * GET : /{type}/authors/{author}   Return specific author for specific type
 *
 * */
@Log4j2
@Controller
public class AuthorMainPageController {

    @Autowired
    AuthorsRepository authorsRepository;

    @GetMapping("/authors")
    public String GETAuthorsController(Model model, HttpServletRequest request){
        Navigation.addLocations(model, request);

        String [] authorsList = authorsRepository.getAllAuthorsPseudonyms();

        model.addAttribute("authorsList", authorsList);

        return "Authors/authors";
    }

    @GetMapping("/types/authors")
    public String GETAllAuthorsController(Model model, HttpServletRequest request){
        Navigation.addLocations(model, request);

        String [] authorsList = authorsRepository.getAllAuthorsPseudonyms();

        model.addAttribute("authorsList", authorsList);

        return "Authors/authors";
    }

    @GetMapping("/types/{type}/authors")
    public String GETAllAuthorsController(Model model,
                                          HttpServletRequest request,
                                          @PathVariable String type){
        Navigation.addLocations(model, request);

        String [] authorsList = authorsRepository.getAllAuthorsPseudonymsByType(type);

        model.addAttribute("authorsList", authorsList);

        return "Authors/authors";
    }

    @GetMapping("/types/{type}/authors/{author}")
    public String GETAuthorController(@PathVariable String author,
                                      @PathVariable String type,
                                      Model model,
                                      HttpServletRequest request){
        Navigation.addLocations(model, request);

        return "Authors/" + author + "/" + author;
    }
}