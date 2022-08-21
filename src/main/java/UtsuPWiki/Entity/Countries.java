package UtsuPWiki.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Countries {

    @Id
    @SequenceGenerator(name = "countries_sequence", sequenceName = "countries_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countries_sequence")
    @Column(name = "ID")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description = "none";
}
