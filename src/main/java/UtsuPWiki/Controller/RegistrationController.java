package UtsuPWiki.Controller;

import UtsuPWiki.Entity.Clients;
import UtsuPWiki.Repository.ClientsRepository;
import UtsuPWiki.utilities.Navigation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@Log4j2
public class RegistrationController {
    @Autowired
    ClientsRepository clientsRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String GETRegistration(@ModelAttribute Clients client,
                                  Model model,
                                  HttpServletRequest request){
        model.addAttribute("client", client);
        Navigation.addLocations(model, request);

        return "registration";
    }

    @PostMapping("/registration-complete")
    public String POSTRegistrationComplete(@ModelAttribute Clients client,
                                           Model model,
                                           HttpServletRequest request){

        model.addAttribute("client", client);

        client.setRegistrationDate(new Date().toString());
        client.setPassword(passwordEncoder.encode(client.getPassword()));

        clientsRepository.save(client);

        Navigation.addLocations(model, request);
        return "registration";
    }
}
