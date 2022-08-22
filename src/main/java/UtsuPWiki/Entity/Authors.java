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
    private String last_name;

    @Column(name = "author_pseudonym", nullable = false)
    private String author_pseudonym;

    @Column(name = "date_of_birth")
    private String date_of_birth;

    @Column(name = "total_masterpieces", nullable = false)
    private int total_masterpieces = 0;

    @Column(name = "additional_info")
    private String additional_info;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id_fk", referencedColumnName = "id")
    private Countries countries;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "main_type_id_fk")
    private Types types;
}
