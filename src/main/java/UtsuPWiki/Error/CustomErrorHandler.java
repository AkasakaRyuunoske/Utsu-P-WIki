package UtsuPWiki.Error;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@Controller
public class CustomErrorHandler implements ErrorController {
    private String errorResponse = "error";

    @RequestMapping("/error")
    public String handleErrors(HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse,
                               Model model){
        int status = httpServletResponse.getStatus();
        log.info("Error handled: " + status);

        if (status > 299){
            handleError(status, model);
        }
        return errorResponse;
    }

    public void handleError(int status, Model model){
        model.addAttribute("error", "Error: " + status);
        switch (status){
            case 404:
                model.addAttribute("errorMessage",
                        "Resource not found or might not exist");
                break;
            case 500:
                model.addAttribute("errorMessage",
                        "Server Side problem.");
                break;
            case 401:
                model.addAttribute("errorMessage",
                        "You have made bad request for some reason." +
                                "Check your request or retry later");
                break;
            default:
                model.addAttribute("errorMessage",
                        "Unexpected problem occurred, try later.");
        }

    }
}
