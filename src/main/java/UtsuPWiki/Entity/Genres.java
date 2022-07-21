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
public class Genres {
    @Id
    @SequenceGenerator(name = "Genres_Sequence", sequenceName = "Genres_Sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Genres_Sequence")
    @Column(name = "ID")
    private long id;

    @Column(name = "Name", nullable = false, unique = true)
    private String name;

    @Column(name = "Description")
    private String description;
}
