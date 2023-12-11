package ma.fiscacostra.dtos;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.*;
import ma.fiscacostra.entities.Vote;
import ma.fiscacostra.enums.Expert;
import ma.fiscacostra.enums.Fonction;
import ma.fiscacostra.enums.Role;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String email;
    //private String password;
    private String nom;
    private String prenom;
    private Fonction fonction;
    private Role role;
    private Expert expert;
    private boolean isExits;
    private Set<VoteResponse> vote;

}
