
package UtsuPWiki.Service;

import UtsuPWiki.Entity.Clients;
import UtsuPWiki.Error.CustomException;
import UtsuPWiki.Repository.ClientsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


/**
 * Custom implementation of UserDetailsService(spring security).
 *
 * Exceptions are not much handled here but in JWTAuthenticationFilter.
 *
 * */

@Log4j2
@Service
public class ClientsDetailsService implements UserDetailsService {
    @Autowired
    ClientsRepository clientsRepository;

    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws BadCredentialsException, InternalAuthenticationServiceException {

        Clients client = clientsRepository.findByUserName(userName);


        if (client == null){
            log.error("UserUnknown was thrown");

            throw new InternalAuthenticationServiceException(this.messages
                    .getMessage("AbstractUserDetailsAuthenticationProvider.UserUnknown",
                            "User was not found."));
        } else {

            try {
                return new User(userName, client.getPassword(), new ArrayList<>());

            } catch (InternalAuthenticationServiceException internalAuthenticationServiceException) {

            log.error("badCredentials was thrown: " + internalAuthenticationServiceException.getMessage());

            throw new CustomException(this.messages
                    .getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials",
                            "User found but password is wrong."));
            }
        }
    }
}