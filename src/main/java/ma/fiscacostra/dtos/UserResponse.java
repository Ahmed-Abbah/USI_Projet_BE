package ma.fiscacostra.dtos;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fiscacostra.entities.Question;
import ma.fiscacostra.entities.Reponse;
import ma.fiscacostra.entities.Vote;
import ma.fiscacostra.enums.Expert;
import ma.fiscacostra.enums.Fonction;
import ma.fiscacostra.enums.Role;

import java.util.Date;
import java.util.List;


@Data
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
    private List<Vote> vote;
    private List<Question> questions;
    private List<Reponse> reponses;
    private Expert expert;

    private Date date;
    private boolean isExits;

}
