package UtsuPWiki.ApiController;

import UtsuPWiki.utilities.SecurityConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@Controller
public class TheDyingMessage {

    @PostMapping("/test-call")
    public String   theDyingMessageReceiver(HttpServletRequest request, HttpServletResponse response){
        String location = request.getHeader("Location");

        log.info("custom header: " + request.getHeader("user"));
        log.info("authorization filter is: "  + request.getHeader(SecurityConstants.HEADER_STRING));
        log.info("Location from Front-End is: " + location);

//        response.setHeader("Location", "http://localhost:8080/authors");
//        response.setStatus(302);
//        try {
//            response.sendRedirect("http://localhost:8080/authors");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        return "redirect:/authors";
    }
}
