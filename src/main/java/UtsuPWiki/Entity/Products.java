package UtsuPWiki.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Products {
    @Id
    @SequenceGenerator(name = "Products_Sequence", sequenceName = "Products_Sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Products_Sequence")
    @Column(name = "ID")
    private long id;

    @Column(name = "Product_Name", nullable = false)
    private String productName;

    @Column(name = "Cost", nullable = false)
    private double cost;

    @Column(name = "Quantity")
    private int quantity = 0;

    @Column(name = "Date_out")
    private String dateOut;

    @Column(name = "product_image", nullable = false)
    private String productImage = "This product has no image.";

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genres_id_fk", referencedColumnName = "id")
    private Genres genres;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Types_id_fk", referencedColumnName = "id")
    private Types types;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Author_id_fk", referencedColumnName = "id")
    private Authors authors;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AdditionalInfo_id_fk", referencedColumnName = "id")
    private ProductsAdditionalInfo productsAdditionalInfo;

    //For Utsu-P (authors.id = 1) Costs for related products are in "$". Exact numbers
    //are taken from Amazon.com (Except for CD-R, there the cost is ￥1,500 to "$" (so it's ~10.99$)

    //Dates are taken from https://vocaloid.fandom.com/wiki/Utsu-P.
}
