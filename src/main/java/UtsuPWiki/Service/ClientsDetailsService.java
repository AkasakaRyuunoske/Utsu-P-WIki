
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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;


@Log4j2
@Service
public class ClientsDetailsService implements UserDetailsService {
    @Autowired
    ClientsRepository clientsRepository;

    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    @Override
    public UserDetails loadUserByUsername(String userName) throws BadCredentialsException, InternalAuthenticationServiceException {

        Clients client = clientsRepository.findByUserName(userName);
        log.info("loadUserByUsername : was called!");
        log.info("client : " + client);

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

    @ExceptionHandler(value = {CustomException.class, InternalAuthenticationServiceException.class})
    public void handleClientsCredentialsError(Exception ex,
                                              CustomException customException,
                                              InternalAuthenticationServiceException internalAuthenticationServiceException){

        log.info("Some error was handled: " + ex.getMessage());

        try{
            if (ex instanceof CustomException){
                log.error("DisableException was handled: " + customException);
            }
            if (ex instanceof InternalAuthenticationServiceException){
                log.error("InternalAuthenticationServiceException was handled: " + internalAuthenticationServiceException);
            }
        } catch (Exception exception) {
            log.warn("Handling of [" + ex.getClass().getName() + "] resulted in Exception", exception);
        }

    }

    @Deprecated
    public Clients readUserByUserName(String userName) throws UsernameNotFoundException {
        Clients client = clientsRepository.findByUserName(userName);

        log.info("readUserByUserName : was called!");
        log.info("client : " + client);
//        log.info("client userName : " + client.getUserName());
//        log.info("client password : " + client.getPassword());

        if (client == null){
            throw new UsernameNotFoundException("User not found or does not exist.");
        }

        return client;
    }
}