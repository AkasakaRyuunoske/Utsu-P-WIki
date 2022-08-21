package UtsuPWiki.ServiceImplementations;

import UtsuPWiki.Entity.Clients;
import UtsuPWiki.Repository.ClientsRepository;
import UtsuPWiki.Service.ClientsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Log4j2
@Service
public class ClientsServiceImp implements ClientsService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ClientsRepository clientsRepository;

    @Override
    public void registerClient(Clients client) {
        client.setRegistration_date(new Date().toString());
        client.setPassword(passwordEncoder.encode(client.getPassword()));

        clientsRepository.save(client);
        log.info("New user was registered.");
    }
}
