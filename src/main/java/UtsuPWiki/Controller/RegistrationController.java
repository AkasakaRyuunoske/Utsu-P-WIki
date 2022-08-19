package UtsuPWiki.Controller;

import UtsuPWiki.Entity.Clients;
import UtsuPWiki.ServiceImplementations.ClientsServiceImp;
import UtsuPWiki.utilities.Navigation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Log4j2
public class RegistrationController {
    @Autowired
    ClientsServiceImp clientsServiceImp;

    @GetMapping("/registration")
    public String GETRegistration(@ModelAttribute Clients client,
                                  Model model,
                                  HttpServletRequest request){
        model.addAttribute("client", client);
        Navigation.addLocations(model, request);

        return "registration";
    }

    @PostMapping("/registration")
    public String POSTRegistrationComplete(@ModelAttribute Clients client,
                                           Model model,
                                           HttpServletRequest request){

        model.addAttribute("client", client);
        Navigation.addLocations(model, request);

        clientsServiceImp.registerClient(client);

        return "redirect:/";
    }
}
