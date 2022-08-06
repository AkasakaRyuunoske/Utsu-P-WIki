package UtsuPWiki.Service;

import UtsuPWiki.Entity.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AuthenticationUserDetailService implements UserDetailsService {
    @Autowired
    ClientsDetailsService clientsDetailsService;

    @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Clients client = clientsDetailsService.readUserByUserName(username);
        if (client == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(
                client.getUserName(),
                client.getPassword(),
                Collections.emptyList());
    }
}