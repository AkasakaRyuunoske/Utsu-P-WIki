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
public class Comments {
    @Id
    @SequenceGenerator(name = "Comments_Sequence", sequenceName = "Comments_Sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Comments_Sequence")
    @Column(name = "ID")
    private long id;

    @Column(name = "Content", nullable = false)
    private String content;

    @Column(name = "Date")
    private String data;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id_fk", referencedColumnName = "id")
    private Clients clients;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "page_id_fk", referencedColumnName = "id")
    private Pages page;
}
