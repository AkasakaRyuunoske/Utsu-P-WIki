package UtsuPWiki.Filter;

import UtsuPWiki.utilities.SecurityConstants;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.jsonwebtoken.JwtException;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *  Filter that checks every filter for tokens and if there is one, tries to validate it
 *
 *
 *  Every thing was made following this guide. https://javatodev.com/spring-boot-jwt-authentication/
 *
 *
 *  EXCEPTIONS are handled inside the filter coz this guy said so
 *  https://stackoverflow.com/questions/48584175/controlleradvice-doesnt-handle-exceptions
 *
 * */

@Log4j2
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    public String token;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                              HttpServletResponse response,
                                              FilterChain chain) throws IOException, ServletException {

        Cookie cookie = WebUtils.getCookie(request, "JWT");

        if (cookie != null) {
            log.info("cookie value is: " + cookie.getValue());
            log.info("cookie name is: " + cookie.getName());
        }

        if (cookie == null || !cookie.getValue().startsWith(SecurityConstants.TOKEN_PREFIX)) {

            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request, response);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request,
                                                                  HttpServletResponse response) {
        try {
            Cookie cookie = WebUtils.getCookie(request, "JWT");

            if (cookie != null) {
                token = cookie.getValue();
            } else {
                throw new NullPointerException("The token is missing in the request.");
            }


            String user = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()))
                    .build()
                    .verify(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
                    .getSubject();

            return new UsernamePasswordAuthenticationToken(user, "none", new ArrayList<>());

        } catch (JwtException jwtException){
            response.setStatus(401);
            throw new IllegalStateException("Token cannot be trusted or is expired. Error message: " + jwtException);
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request){
        String path = request.getRequestURL().toString();

        return path.contains("/css/")           ||
                path.contains("/js/")           ||
                path.contains(".jpg")           ||
                path.contains(".png")           ||
                path.contains("/test-call")     ||
                path.contains("/login")         ||
                path.contains("/registration")  ||
                path.contains("/logout")        ||
                path.contains("/error");
    }

    @Override
    protected boolean shouldNotFilterAsyncDispatch() {
        return true;
    }

    @Override
    protected boolean shouldNotFilterErrorDispatch() {
        return true;
    }
}
