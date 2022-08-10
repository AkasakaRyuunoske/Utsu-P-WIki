package UtsuPWiki.Repository;

import UtsuPWiki.Entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {
    Clients findByUserName(String userName);
}
