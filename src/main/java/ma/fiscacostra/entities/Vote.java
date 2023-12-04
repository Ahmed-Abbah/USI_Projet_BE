package ma.fiscacostra.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fiscacostra.enums.TypeQuestion;

@Entity
@Data
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

    @JsonIgnore
    @ManyToOne
    private Reponse reponse;

    @JsonIgnore
    @ManyToOne
    private User user;
}
