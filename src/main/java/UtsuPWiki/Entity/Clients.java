package UtsuPWiki.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Clients {

    @Id
    @SequenceGenerator(name = "Clients_Sequence", sequenceName = "Clients_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Clients_Sequence")
    @Column(name = "ID")
    private long id;

    @Column(name = "UserName", nullable = false, unique = true)
    private String userName;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Role", nullable = false)
    private String role = "Client";

    @Column(name = "Content_Created", nullable = false)
    private int contentCreated = 0;

    //todo idk how to make the thing, so for now it'll be commented out
//    @Column(name = "Profile_Photo", nullable = false, unique = false)
//    private Blob profilePhoto;

    @Column(name = "Default_Address")
    private String default_Address = "none";

    @Column(name = "Registration_Date", nullable = false)
    private String registrationDate;

    @Column(name = "Comments_Quantity", nullable = false)
    private int commentsQuantity = 0;
}
