package ma.fiscacostra.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ma.fiscacostra.enums.TypeQuestion;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private TypeQuestion type;

    @JsonIgnore
    @ManyToOne
    private User user;

    @JsonIgnore
    @ManyToOne
    private Metier metier;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Reponse> reponses;


    @OneToOne(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Vote vote;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();
}
