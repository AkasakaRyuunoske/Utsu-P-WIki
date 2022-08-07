package UtsuPWiki.Controller;

import UtsuPWiki.Entity.Clients;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class LoginController {

    @PostMapping("/login")
    public String GETLogin(Model model){
        model.addAttribute("client", new Clients());
        log.info("was called!");
        return "login";
    }

    @GetMapping("/login")
    public String POSTLogin(@ModelAttribute Clients client){
        log.info(client.getPassword() + " password");
        log.info(client.getUserName() + " username");

        return "index";
    }
}
