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

    @Column(name = "First_Name", nullable = false, unique = false)
    private String firstName;

    @Column(name = "Last_Name", nullable = false, unique = false)
    private String lastName;

    @Column(name = "TotalQuantityOfDeliveredProducts", nullable = false, unique = false)
    private int totalQuantityOfDeliveredProducts = 0;

    @Column(name = "Availability", nullable = false, unique = false)
    private boolean availability = false;
}
