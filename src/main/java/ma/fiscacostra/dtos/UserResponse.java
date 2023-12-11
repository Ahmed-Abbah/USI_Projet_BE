package ma.fiscacostra.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.fiscacostra.entities.Question;
import ma.fiscacostra.entities.Reponse;
import ma.fiscacostra.entities.Vote;
import ma.fiscacostra.enums.Expert;
import ma.fiscacostra.enums.Fonction;
import ma.fiscacostra.enums.Role;
import java.util.Date;
import java.util.List;
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
    private List<Question> questions;
    private List<Reponse> reponses;
    private Expert expert;

    private Date date;
    private boolean isExits;
    private Set<VoteResponse> vote;

}
