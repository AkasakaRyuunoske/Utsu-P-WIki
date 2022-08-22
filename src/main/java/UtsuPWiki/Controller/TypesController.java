package UtsuPWiki.Controller;

import UtsuPWiki.Repository.TypesRepository;
import UtsuPWiki.utilities.Navigation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Log4j2
public class TypesController {
    @Autowired
    TypesRepository typesRepository;

    @GetMapping("/types")
    private String GETAllTypes(Model model, HttpServletRequest request){

        Navigation.addLocations(model, request);

        String [] typesList = typesRepository.getAllTypesNames();

        model.addAttribute("typesList", typesList);

        return "types";
    }


}
