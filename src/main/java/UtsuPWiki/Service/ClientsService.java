package UtsuPWiki.Service;

import UtsuPWiki.Entity.Clients;
import org.springframework.stereotype.Service;

@Service
public interface ClientsService {
    void registerClient(Clients client);
}
