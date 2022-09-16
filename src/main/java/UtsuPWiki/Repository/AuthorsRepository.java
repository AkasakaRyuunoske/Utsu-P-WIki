package UtsuPWiki.Repository;

import UtsuPWiki.Entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long> {
    @Query("SELECT authorPseudonym FROM Authors")
    String[] getAllAuthorsPseudonyms();

    @Query("SELECT authors.authorPseudonym FROM Authors as authors, Types as types_table where authors.types = types_table.id AND types_table.name = :type")
    String[] getAllAuthorsPseudonymsByType(String type);

    @Query("SELECT authors.authorPseudonym FROM Authors as authors, Genres as genres_table where authors.genres = genres_table.id AND genres_table.name = :genre")
    String[] getAllAuthorsPseudonymsByGenre(String genre);
}
