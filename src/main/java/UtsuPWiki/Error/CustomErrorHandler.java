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
    private final String ERROR_PAGE = "error"; // Name of the view that will be returned
    private final String ERROR_MESSAGE = "errorMessage";

    @RequestMapping("/error")
    public String handleErrors(HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse,
                               Model model){
        int status = httpServletResponse.getStatus();
        log.info("Error handled: " + status);

        if (status > 299){
            handleError(status, model);
        }

        return ERROR_PAGE;
    }

    public void handleError(int status, Model model){
        model.addAttribute("error", "Error: " + status);
        switch (status){
            case 401:
                model.addAttribute(ERROR_MESSAGE,
                        "You have made bad request for some reason." +
                                "Check your request or retry later.");
                break;

            case 403:
                model.addAttribute(ERROR_MESSAGE,
                        "You are not allowed to view this page.");
                break;

            case 404:
                model.addAttribute(ERROR_MESSAGE,
                        "Resource not found or might not exist.");
                break;

            case 405:
                model.addAttribute(ERROR_MESSAGE,
                        "HTTP method not allowed.");
                break;

            case 500:
                model.addAttribute(ERROR_MESSAGE,
                        "Server Side problem.");
                break;

            default:
                model.addAttribute(ERROR_MESSAGE,
                        "Unexpected problem occurred, try later.");
        }

    }
}
