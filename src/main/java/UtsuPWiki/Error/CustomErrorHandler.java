package UtsuPWiki.Error;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@Controller
public class CustomErrorHandler implements ErrorController {
    private String errorResponse;

    @RequestMapping("/error")
    public String handleErrors(HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse,
                               Model model){
        int status = httpServletResponse.getStatus();
        log.info("Error handled: " + status);

        if (status == 404){

            handleError404(status, model);

        } else {

            log.info("idk this error: " + status);

            model.addAttribute("error", httpServletResponse.getStatus());

            errorResponse = "error";
        }

        return errorResponse;
    }

    public void handleError404(int status, Model model){

        model.addAttribute("error",
                "yeay handleError404 worked here!");

        errorResponse = "error";
    }
}
