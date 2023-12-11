package ma.fiscacostra.entities;


import jakarta.persistence.*;
import lombok.*;
import ma.fiscacostra.enums.Expert;
import ma.fiscacostra.enums.Fonction;
import ma.fiscacostra.enums.Role;

import java.util.List;
import java.util.Set;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private Fonction fonction;
    private Role role = Role.EMPLOYEE; // On suppose que les utilisateurs dont nous ajoutons sont des tous des employees
    private Expert expert = Expert.NON;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Vote> vote;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Question> questions;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Reponse> reponses;


}
