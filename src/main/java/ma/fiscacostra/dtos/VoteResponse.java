package ma.fiscacostra.dtos;


import lombok.*;
import ma.fiscacostra.entities.Question;
import ma.fiscacostra.entities.User;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoteResponse {
    private  Long id;
    private int nbreVote;
//    private QuestionResponse question;
    private Set<User> votedUsers;
}
