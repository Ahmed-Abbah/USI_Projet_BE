package ma.fiscacostra.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ma.fiscacostra.enums.TypeQuestion;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int nbreVote;

    @JsonIgnore
    @OneToOne
    private Question question;

//    @JsonIgnore
//    @ManyToOne
//    private Reponse reponse;

//    @JsonIgnore
//    @ManyToOne
//    private User user;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> votedUsers;
}
