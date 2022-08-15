package UtsuPWiki.Filter;

import UtsuPWiki.utilities.SecurityConstants;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.jsonwebtoken.JwtException;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * Poorly made both JWTAuthorization and JWTAuthentication filters.
 *
 *  Every thing was made following this guide. https://javatodev.com/spring-boot-jwt-authentication/
 *
 * */

@Log4j2
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    public String token;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                              HttpServletResponse response,
                                              FilterChain chain) throws IOException, ServletException {

        String header = request.getHeader(SecurityConstants.HEADER_STRING);

        log.info("################################################################");
        log.info("doFilterInternal was called: " + header);
        log.info("URL = " + request.getRequestURL());

        if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {

            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request, response);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request,
                                                                  HttpServletResponse response) {

        token = request.getHeader(SecurityConstants.HEADER_STRING);
        try {
            String user = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()))
                    .build()
                    .verify(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
                    .getSubject();

            response.addHeader(SecurityConstants.HEADER_STRING, token);

            return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
        } catch (JwtException jwtException){
            throw new IllegalStateException("Token cannot be trusted or is expired. Error message: " + jwtException);
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request){
        String path = request.getRequestURL().toString();

        return path.contains("/css/") ||
                path.contains("/js/") ||
                path.contains(".jpg") ||
                path.contains(".png") ||
                path.contains("/test-call") ||
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
