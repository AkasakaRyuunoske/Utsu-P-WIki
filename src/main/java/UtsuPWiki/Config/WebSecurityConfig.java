package UtsuPWiki.Config;

import UtsuPWiki.Filter.JWTAuthenticationFilter;
import UtsuPWiki.Filter.JWTAuthorizationFilter;
import UtsuPWiki.Service.AuthenticationUserDetailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

    public final String[] INACCESSIBLE_URLS_BY_NOT_AUTHENTICATED_USERS = {
            "/authors",
            //these are CMS end points, obviously to manipulate data user must be authenticated
            "/create",
            "/update",
            "/delete"
    };

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilterAfter(new JWTAuthorizationFilter(), JWTAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(INACCESSIBLE_URLS_BY_NOT_AUTHENTICATED_USERS)
                .authenticated()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login").deleteCookies("JWT","userName");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationUserDetailService)
                .passwordEncoder(new BCryptPasswordEncoder(11));
    }
}
