package UtsuPWiki.Service;

import UtsuPWiki.Entity.Clients;
import UtsuPWiki.Repository.ClientsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Log4j2
@Service
public class ClientsDetailsService implements UserDetailsService {
    @Autowired
    ClientsRepository clientsRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("loadUserByUsername : was called!");
        return new User(userName,
                clientsRepository.findByUserName(userName).getPassword(),
                new ArrayList<>());
    }


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