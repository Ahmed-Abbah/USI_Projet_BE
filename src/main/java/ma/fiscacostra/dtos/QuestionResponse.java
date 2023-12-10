package ma.fiscacostra.dtos;


import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fiscacostra.entities.Metier;
import ma.fiscacostra.entities.Reponse;
import ma.fiscacostra.entities.User;
import ma.fiscacostra.entities.Vote;
import ma.fiscacostra.enums.TypeQuestion;

import java.util.List;


@Data @NoArgsConstructor @AllArgsConstructor
public class QuestionResponse {

    private Long id;
    private String question;
    private TypeQuestion type;

    private List<VoteResponse> vote;

    private Metier metier;
    private UserResponse user;
    private List<ReponseResponse> reponses;

}
