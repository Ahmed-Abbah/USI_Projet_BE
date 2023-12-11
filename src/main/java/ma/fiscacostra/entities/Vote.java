package ma.fiscacostra.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ma.fiscacostra.enums.TypeQuestion;

import java.util.Date;

@Entity
//@Data
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
    @ManyToOne
    private Question question;

//    @JsonIgnore
//    @ManyToOne
//    private Reponse reponse;

    @JsonIgnore
    @ManyToOne
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();
}
