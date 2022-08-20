package UtsuPWiki.Controller;

import UtsuPWiki.Repository.GenresRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Log4j2
@Controller
public class CategoriesPageController {
    @Autowired
    GenresRepository genresRepository;

    @GetMapping("/home/categories")
    public String GETTypes(Model model,
                           HttpServletRequest request){
//        ArrayList<String> genresNames = genresRepository.getAllGenresNames();
//
//        model.addAttribute("genresNames", genresNames);


        return "categories";
    }
}
