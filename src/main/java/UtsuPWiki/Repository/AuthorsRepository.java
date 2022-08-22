package UtsuPWiki.Repository;

import UtsuPWiki.Entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long> {
    @Query("SELECT authorPseudonym FROM Authors")
    String[] getAllAuthorsPseudonyms();

}
