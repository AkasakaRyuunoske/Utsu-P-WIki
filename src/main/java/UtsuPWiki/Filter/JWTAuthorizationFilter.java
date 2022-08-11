package UtsuPWiki.Filter;

import UtsuPWiki.utilities.SecurityConstants;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
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

@WebFilter("/*")
@Log4j2
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public String token;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                              HttpServletResponse response,
                                              FilterChain chain) throws IOException, ServletException {

        String header = request.getHeader(SecurityConstants.HEADER_STRING);

        log.info("doFilterInternal was called: " + header);


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
        if (token != null) {

            String user = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()))
                    .build()
                    .verify(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
                    .getSubject();

            response.addHeader(SecurityConstants.HEADER_STRING, token);
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }
}
