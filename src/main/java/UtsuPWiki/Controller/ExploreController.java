package UtsuPWiki.Controller;

import UtsuPWiki.Repository.GenresRepository;
import UtsuPWiki.Repository.TypesRepository;
import UtsuPWiki.utilities.Navigation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller
public class ExploreController {

    /**
     *  Second by importance page (after main page). Provides user with some tools
     *  to help them in searching the author they were searching for.
     *
     *  At least for now only responds to GET /explore and other than predefined html data
     *  adds Types and Genres as hyperlink attributes.
     *
     * */
    @Autowired
    TypesRepository typesRepository;
    @Autowired
    GenresRepository genresRepository;
    @GetMapping("/explore")
    public String GETExplore(Model model, HttpServletRequest request){
        Navigation.addLocations(model, request);

        // Getting types and genres from database to display them on the model
        String [] typesList  = typesRepository.getAllTypesNames();
        String [] genresList = genresRepository.getAllGenresNames();

        // Adding types and genres on the model
        model.addAttribute("typesList", typesList);
        model.addAttribute("genresList", genresList);

        // Returns explore.html with new attributes
        return "explore";
    }
}
