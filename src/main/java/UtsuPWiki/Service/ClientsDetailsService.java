package UtsuPWiki.Service;

import UtsuPWiki.Entity.Clients;
import UtsuPWiki.Repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service
public class ClientsDetailsService implements UserDetailsService {
    @Autowired
    ClientsRepository clientsRepository;

    BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        return new User("Oleg",
                "$2a$11$ltlpU7OwyTMmUwmMJgSpU.uo5H4A2xdm1an6XC6SWSyKCe9Lr32ZS",
                new ArrayList<>());
    }


    public Clients readUserByUserName(String userName) {
        return clientsRepository.findByUserName(userName).orElseThrow(EntityNotFoundException::new);
    }
}