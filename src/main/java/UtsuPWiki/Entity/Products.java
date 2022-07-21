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

    @Column(name = "Type", nullable = false)
    private String type;

    @Column(name = "Author", nullable = false)
    private String author;

    @Column(name = "Cost", nullable = false)
    private double cost;

    @Column(name = "Quantity")
    private int quantity = 0;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genres_id_fk", referencedColumnName = "id")
    private Genres genres;
}
