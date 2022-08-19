package UtsuPWiki.Error;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Is used to handle all Http error status codes(400 - 599).
 *
 * First method must be used as a config and the handleError to handle the actual errors
 * */
@Log4j2
@Controller
public class CustomErrorHandler implements ErrorController {
    @SuppressWarnings("FieldCanBeLocal")
    private final String ERROR_PAGE = "error"; // Name of the view that will be returned
    @SuppressWarnings("FieldCanBeLocal")
    private final String ATTRIBUTE_ERROR_MESSAGE = "errorMessage"; //name of the thymeleaf attribute
    private String error_message;

    @RequestMapping("/error")
    public String handleErrors(HttpServletRequest request,
                               HttpServletResponse response,
                               Model model){

        int status = response.getStatus();
        log.info("Error handled: " + status);

            handleError(status, model);

        response.setHeader(ATTRIBUTE_ERROR_MESSAGE, error_message);

        return ERROR_PAGE;
    }

    public void handleError(int status, Model model){
        model.addAttribute("error", "Error: " + status);
        switch (status){
            // 400 - 499 Client Side Errors
            case 400:
                error_message = "You have made bad request for some reason. Check your request or retry later.";
                model.addAttribute(ATTRIBUTE_ERROR_MESSAGE, error_message);
                break;

            case 401:
                error_message = "User name or password are incorrect or user does not exist.";
                model.addAttribute(ATTRIBUTE_ERROR_MESSAGE, error_message);
                break;

            case 403:
                error_message = "You are not allowed to view this page.";
                model.addAttribute(ATTRIBUTE_ERROR_MESSAGE, error_message);
                break;

            case 404:
                error_message = "Resource not found or might not exist.";
                model.addAttribute(ATTRIBUTE_ERROR_MESSAGE,error_message);
                break;

            case 405:
                error_message = "HTTP method not allowed.";
                model.addAttribute(ATTRIBUTE_ERROR_MESSAGE,error_message);
                break;


            case 453:
                error_message = "Custom Error.";
                model.addAttribute(ATTRIBUTE_ERROR_MESSAGE, error_message);
                break;
            // 500 - 599 Server side Errors
            case 500:
                error_message = "Server Side problem. If error remains, retry later.";
                model.addAttribute(ATTRIBUTE_ERROR_MESSAGE, error_message);
                break;

            default:
                error_message = "Unexpected problem occurred, try later.";
                model.addAttribute(ATTRIBUTE_ERROR_MESSAGE, error_message);
        }
    }
}
