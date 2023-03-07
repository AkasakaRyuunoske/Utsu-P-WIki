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
public class ProductsAdditionalInfo {
    @Id
    @SequenceGenerator(name = "AdditionalInfoSequence", sequenceName = "AdditionalInfoSequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AdditionalInfoSequence")
    @Column(name = "id")
    private long id;

    @Column(name = "song_name")
    private String song_name;

    @Column(name = "link_spotify")
    private String linkSpotify;

    @Column(name = "link_wiki")
    private String linkWiki;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id_fk", referencedColumnName = "id")
    private Products products;
}
