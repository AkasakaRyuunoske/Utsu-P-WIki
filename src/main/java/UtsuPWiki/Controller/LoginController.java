package UtsuPWiki.Controller;

import UtsuPWiki.Entity.Clients;
import UtsuPWiki.Repository.ClientsRepository;
import UtsuPWiki.utilities.SecurityConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;

@Log4j2
@Controller
public class LoginController {
    @Autowired
    ClientsRepository clientsRepository;

    @PostMapping("/login")
    public String GETLogin(Model model){
        model.addAttribute("client", new Clients());


        return "login";
    }

    @GetMapping("/login")
    public String POSTLogin(@ModelAttribute Clients client){

        return "login";
    }
}
