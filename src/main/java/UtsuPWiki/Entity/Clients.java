package UtsuPWiki.Entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Clients {

    @Id
    @SequenceGenerator(name = "Clients_Sequence", sequenceName = "Clients_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Clients_Sequence")
    @Column(name = "ID")
    private long id;

    @Column(name = "UserName", nullable = false, unique = true)
    private String userName;

    @Column(name = "Password", nullable = false, unique = false)
    private String password;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Role", nullable = false, unique = false)
    private String role = "Client";

    @Column(name = "Content_Created", nullable = false, unique = false)
    private int contentCreated = 0;

    //todo idk how to make the thing, so for now it'll be commented out
//    @Column(name = "Profile_Photo", nullable = false, unique = false)
//    private Blob profilePhoto;

    @Column(name = "Session_Id", nullable = true, unique = false)
    private String sessionId;

    @Column(name = "Default_Address", nullable = true, unique = false)
    private String default_Address = "none";
}
