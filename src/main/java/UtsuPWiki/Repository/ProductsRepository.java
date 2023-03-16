package UtsuPWiki.Repository;

import UtsuPWiki.Entity.Products;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    @Query(value = "SELECT * FROM Products WHERE product_name = :name", nativeQuery = true)
    Products selectProductByProductName(String name);

    @Query(value = "SELECT song_name FROM products_additional_info WHERE product_id_fk = :id_album",
                   nativeQuery = true)
    String[] selectTrackListByAlbumId(long id_album);

    @Query(value = "select contains from products where id = :id", nativeQuery = true)
    String selectContainsById(long id);
}
