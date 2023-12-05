package ma.fiscacostra.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fiscacostra.enums.Fonction;
import ma.fiscacostra.enums.Role;

import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private Fonction fonction;
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Vote> vote;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Question> questions;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Reponse> reponses;
}
