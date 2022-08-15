package UtsuPWiki.ApiController;

import UtsuPWiki.utilities.SecurityConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/test-call")
    public String theDyingMessageReceiver(HttpServletRequest request, HttpServletResponse response){

        log.info("custom header: " + request.getHeader("user"));
        log.info("authorization filter is: "  + request.getHeader(SecurityConstants.HEADER_STRING));
        String token = request.getHeader(SecurityConstants.HEADER_STRING);
        log.info("token is: " + token);
        response.setHeader(SecurityConstants.HEADER_STRING, token);
//        response.setHeader("The Dying Message", "By Utsu-P");
//        response.setHeader("Location", "/authors");
//        response.setStatus(302);
//        try {
//            response.sendRedirect("/authors");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        return "redirect:/authors";
    }
}
