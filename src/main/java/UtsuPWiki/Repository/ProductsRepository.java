package UtsuPWiki.Repository;

import UtsuPWiki.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    @Query("SELECT productName FROM Products")
    String[] getAllProductsNames();

    @Query(value = "SELECT additional_info FROM Products", nativeQuery = true)
    String[] getAllProperties();
//    @Query("SELECT * FROM Products where author_id_fk = :author_id")
//    String[] getAllproductsByAuthorsId();
}
