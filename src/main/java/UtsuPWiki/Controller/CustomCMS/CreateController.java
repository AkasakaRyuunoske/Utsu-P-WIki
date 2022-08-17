package UtsuPWiki.Controller.CustomCMS;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

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
        log.info("some one wants to create something!");
        log.info("request for /create contains: " + Arrays.toString(request.getCookies()));
        return "CMS/create";
    }

    @PutMapping("/create")
    public void PUTCreate(){
        log.info("Was called!");
    }
}
