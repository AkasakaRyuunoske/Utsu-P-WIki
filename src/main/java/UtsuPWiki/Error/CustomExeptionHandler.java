package UtsuPWiki.Error;

import com.auth0.jwt.exceptions.JWTVerificationException;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.auth0.jwt.exceptions.TokenExpiredException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@ControllerAdvice
public class CustomExeptionHandler extends AbstractHandlerExceptionResolver {

    @Override
    @ExceptionHandler(value = { IllegalArgumentException.class,
            IllegalStateException.class, ExpiredJwtException.class,
            JWTVerificationException.class,
            TokenExpiredException.class,
            DisabledException.class,
            InternalAuthenticationServiceException.class})
    protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse response,
                                              Object handler,
                                              Exception ex) {
        log.info("was called!");
        try{
            if (ex instanceof DisabledException){
                log.error("DisableException was handled");
            }
            if (ex instanceof InternalAuthenticationServiceException){
                log.error("InternalAuthenticationServiceException was handled");
            }
        } catch (Exception exception) {
            log.warn("Handling of ["
                    + ex.getClass().getName() +
                    "] resulted in Exception", exception);
         }

        return null;
    }

    protected String handleError(HttpServletRequest request, HttpServletResponse response){
        log.info("error was handled: " + request.getRequestURL());

        handleException(new DisabledException("user was not found"), response);

        return "error";
    }


    public void handleException(DisabledException disabledException, HttpServletResponse response) {
        log.info("handleException was called");
        log.error("DisabledException was handled: " + disabledException);
        response.setStatus(453);
    }


}
