package UtsuPWiki.Repository;

import UtsuPWiki.Entity.Couriers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouriersRepository extends JpaRepository<Couriers, Long> {
}
