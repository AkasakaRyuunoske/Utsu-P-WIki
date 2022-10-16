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
import java.io.File;
import java.io.IOException;

@Log4j2
@Controller
public class ExploreController {
    @Autowired
    TypesRepository typesRepository;
    @Autowired
    GenresRepository genresRepository;
    @GetMapping("/explore")
    public String GETExplore(Model model, HttpServletRequest request){
        Navigation.addLocations(model, request);

        String [] typesList = typesRepository.getAllTypesNames();

        String [] genresList = genresRepository.getAllGenresNames();

        model.addAttribute("typesList", typesList);
        model.addAttribute("genresList", genresList);

        return "explore";
    }
}
