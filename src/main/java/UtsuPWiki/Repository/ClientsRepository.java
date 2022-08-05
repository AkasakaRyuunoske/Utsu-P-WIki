package UtsuPWiki.Repository;

import UtsuPWiki.Entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {
}
