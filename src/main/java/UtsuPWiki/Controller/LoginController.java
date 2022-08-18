package UtsuPWiki.Controller;

import UtsuPWiki.Entity.Clients;
import UtsuPWiki.Service.ClientsDetailsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class LoginController {

    //The page client can see and insert data
    @GetMapping("/login")
    public String GETLogin(@ModelAttribute Clients client){

        return "login";
    }

   //only receives data, must NOT be viewed by clients
    @PostMapping("/login")
    public void POSTLogin(Model model){
        model.addAttribute("client", new Clients());
        log.info("Post Login was called!");
    }
}
