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
public class Pages {
    @Id
    @SequenceGenerator(name = "Pages_Sequence", sequenceName = "Pages_Sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Pages_Sequence")
    @Column(name = "ID")
    private long id;

    @Column(name = "Name", nullable = false, unique = true)
    private String name;

    @Column(name = "Header", nullable = false)
    private String header;

    @Column(name = "Footer", nullable = false)
    private String footer;

    @Column(name = "Author",  nullable = false)
    private String author;

    @Column(name = "Description")
    private String description = "none";

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id_fk", referencedColumnName = "id")
    private Clients clients;
}
