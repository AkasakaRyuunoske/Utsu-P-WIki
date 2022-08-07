package UtsuPWiki.Config;

import UtsuPWiki.Filter.JWTAuthenticationFilter;
import UtsuPWiki.Filter.JWTAuthorizationFilter;
import UtsuPWiki.Service.AuthenticationUserDetailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Log4j2
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(11);
    }
    @Autowired
    public AuthenticationUserDetailService authenticationUserDetailService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        log.info("Was called!");
        httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/login",
                        "/registration",
                        "/registration-complete",
                        "/css/styles.css",
                        "/css/full-glitch-effect-text.css")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationUserDetailService)
                .passwordEncoder(new BCryptPasswordEncoder(11));
    }
}
