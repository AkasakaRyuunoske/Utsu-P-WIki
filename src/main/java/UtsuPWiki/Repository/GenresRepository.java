package UtsuPWiki.Repository;

import UtsuPWiki.Entity.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GenresRepository extends JpaRepository<Genres, Long> {
    @Query(value = "SELECT name FROM Genres",
            nativeQuery = true)
    ArrayList<String> getAllGenresNames();
}
