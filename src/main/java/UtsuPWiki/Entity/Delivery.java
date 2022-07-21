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
public class Delivery {
    @Id
    @SequenceGenerator(name = "Delivery_Sequence", sequenceName = "Delivery_Sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Delivery_Sequence")
    @Column(name = "ID")
    private long id;

    @Column(name = "Address_To", nullable = false)
    private String addressTo;

    @Column(name = "Address_From", nullable = false)
    private String addressFrom;

    @Column(name = "Date", nullable = false)
    private String date;

    @Column(name = "Additional_Info")
    private String additionalInfo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_courier_fk", referencedColumnName = "id")
    private Couriers couriers;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order_fk", referencedColumnName = "id")
    private Orders orders;
}
