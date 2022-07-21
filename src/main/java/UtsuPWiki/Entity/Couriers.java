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
public class Couriers {
    @Id
    @SequenceGenerator(name = "Couriers_Sequence", sequenceName = "Couriers_Sequence")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "Couriers_Sequence")
    @Column(name = "ID")
    private long id;

    @Column(name = "First_Name", nullable = false)
    private String firstName;

    @Column(name = "Last_Name", nullable = false)
    private String lastName;

    @Column(name = "TotalQuantityOfDeliveredProducts", nullable = false)
    private int totalQuantityOfDeliveredProducts = 0;

    @Column(name = "Availability", nullable = false)
    private boolean availability = false;
}
