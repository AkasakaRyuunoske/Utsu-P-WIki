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

    @Column(name = "contains")
    private String contains;

    @Column(name = "link_spotify")
    private String linkSpotify;

    @Column(name = "link_wiki")
    private String linkWiki;

    @Column(name = "track_list")
    private String trackList;

}
