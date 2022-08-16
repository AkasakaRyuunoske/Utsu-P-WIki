package UtsuPWiki.Error;

import com.auth0.jwt.exceptions.JWTVerificationException;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.auth0.jwt.exceptions.TokenExpiredException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@ControllerAdvice
public class CustomExeptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class,
            IllegalStateException.class, ExpiredJwtException.class,
            JWTVerificationException.class,
            TokenExpiredException.class})
    protected String handleIllegalArgumentException(HttpServletRequest request, HttpServletResponse response){
        log.info("error was handled: " + request.getRequestURL());

        return "error";
    }
}
