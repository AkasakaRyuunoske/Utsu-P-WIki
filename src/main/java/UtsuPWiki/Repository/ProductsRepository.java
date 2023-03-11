package UtsuPWiki.Repository;

import UtsuPWiki.Entity.Products;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    @Query("SELECT productName FROM Products")
    String[] getAllProductsNames();

    @Query(value = "SELECT additional_info FROM Products", nativeQuery = true)
    String[] getAllProperties();
//    @Query("SELECT * FROM Products where author_id_fk = :author_id")
//    String[] getAllproductsByAuthorsId();
    @Query(value = "SELECT * FROM Products WHERE product_name = :name", nativeQuery = true)
    Products selectProductByProductName(String name);

    //todo get track list by name

    @Query(value = "SELECT song_name, id FROM products_additional_info WHERE product_id_fk = :id_album",
                   nativeQuery = true)
    String[] selectTrackListByAlbumId(long id_album);
}
