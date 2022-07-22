package UtsuPWiki.Repository;

import UtsuPWiki.Entity.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresRepository extends JpaRepository<Genres, Long> {
}
