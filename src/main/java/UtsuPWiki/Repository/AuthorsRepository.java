package UtsuPWiki.Repository;

import UtsuPWiki.Entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long> {
    Authors findByAuthor_Pseudonym(String author_pseudonym);

}
