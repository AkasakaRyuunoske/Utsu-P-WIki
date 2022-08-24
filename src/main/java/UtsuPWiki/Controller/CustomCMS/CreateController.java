package UtsuPWiki.Controller.CustomCMS;

import UtsuPWiki.utilities.Navigation;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Will serve creation of the html pages from front-end.
 * */

@Log4j2
@Controller
public class CreateController {
    @GetMapping("/create")
    public String GETCreate(Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){
        Navigation.addLocations(model, request);
        return "CMS/create";
    }

    @PutMapping("/create")
    public void PUTCreate(){
        log.info("Was called!");
    }
}
