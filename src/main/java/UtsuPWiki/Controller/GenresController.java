package UtsuPWiki.Controller;

import UtsuPWiki.Repository.AuthorsRepository;
import UtsuPWiki.Repository.GenresRepository;
import UtsuPWiki.utilities.Navigation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller
public class GenresController {
    @Autowired
    GenresRepository genresRepository;

    @Autowired
    AuthorsRepository authorsRepository;

    @GetMapping("/genres")
    public String GETGenres(Model model,
                           HttpServletRequest request){
        Navigation.addLocations(model, request);

        String [] genresList = genresRepository.getAllGenresNames();
        model.addAttribute("genresList", genresList);

        return "genres";
    }

    @GetMapping("/genres/{genre}")
    public String GETGenre(Model model,
                           HttpServletRequest request,
                           @PathVariable String genre){
        Navigation.addLocations(model, request);

        String [] genresList = genresRepository.getAllGenresNames();
        model.addAttribute("genresList", genresList);

        String [] authorsByGenreList = authorsRepository.getAllAuthorsPseudonymsByGenre(genre);
        model.addAttribute("authorsByGenreList", authorsByGenreList);

        log.info("Genres are: " + genre);
        return "Genres/" + genre;
    }
}
