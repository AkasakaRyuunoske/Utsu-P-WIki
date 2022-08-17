package UtsuPWiki.Filter;

import UtsuPWiki.Entity.Clients;
import UtsuPWiki.utilities.SecurityConstants;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm; // 8 anniversary (Aug 17, 2014)
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@RequiredArgsConstructor
@Log4j2
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try {
            Clients creds = new ObjectMapper()
                    .readValue(request.getInputStream(), Clients.class);

            if (creds.getUserName() == null){
                log.info("RuntimeException was thrown in creds.getUserName == null");
                throw new RuntimeException("User does not exist or username is wrong.");
            }

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUserName(),
                            creds.getPassword(),    //Is already using defined as @Bean password encoder(BCrypt(11))
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        User user = ((User) auth.getPrincipal());
        String username = user.getUsername();

        String token = JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()));

        log.info(token + " token that was created!");

        Cookie jwt_cookie = new Cookie("JWT", SecurityConstants.TOKEN_PREFIX + token);
        jwt_cookie.setMaxAge(60 * 60); //Same one hour, but SecurityConstants.EXPIRATION_TIME cannot be used coz it's Long
        jwt_cookie.setHttpOnly(true);

        if (username.contains(" ")){
            username = username.replace(" ", "_");
        }

        Cookie userName_cookie = new Cookie("userName", username);

        response.addCookie(jwt_cookie);
        response.addCookie(userName_cookie);

        response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
    }
}
