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
public class Authors {

    @Id
    @SequenceGenerator(name = "Authors_Sequence", sequenceName = "Authors_Sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Authors_Sequence")
    @Column(name = "ID")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "author_pseudonym", nullable = false)
    private String authorPseudonym;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "total_masterpieces", nullable = false)
    private int totalMasterpieces = 0;

    @Column(name = "additional_info")
    private String additionalInfo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id_fk", referencedColumnName = "id")
    private Countries countries;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "main_type", referencedColumnName = "id")
    private Types types;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "main_genre", referencedColumnName = "id")
    private Genres genres;
}
