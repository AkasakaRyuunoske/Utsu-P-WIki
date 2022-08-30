package UtsuPWiki.Controller;

import UtsuPWiki.utilities.Navigation;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller
public class BuyController {
    @GetMapping("/buy")
    public String GETBuy(Model model, HttpServletRequest request){
        Navigation.addLocations(model, request);

        return "buy";
    }
}
