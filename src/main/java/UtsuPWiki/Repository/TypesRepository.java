package UtsuPWiki.Repository;

import UtsuPWiki.Entity.Types;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TypesRepository extends JpaRepository<Types, Long> {

    @Query("SELECT name FROM Types")
    String[] getAllTypesNames();
}
