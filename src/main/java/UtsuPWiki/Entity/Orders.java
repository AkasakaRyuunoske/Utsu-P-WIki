package UtsuPWiki.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {
    @Id
    @SequenceGenerator(name = "Orders_Sequence", sequenceName = "Orders_Sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Orders_Sequence")
    @Column(name = "ID")
    private long id;

    @Column(name = "Date", nullable = false)
    private String date;

    @Column(name = "Client_Amount", nullable = false)
    private double clientAmount;

    @Column(name = "Products_Aquired", nullable = false)
    private String productsAquired;

    @Column(name = "Products_Quantity", nullable = false)
    private int productsQuantity;

    @Column(name = "Total_Cost", nullable = false)
    private double totalCost;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id_fk", referencedColumnName = "id")
    private Clients clients;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id_fk", referencedColumnName = "id")
    private Products products;
}
