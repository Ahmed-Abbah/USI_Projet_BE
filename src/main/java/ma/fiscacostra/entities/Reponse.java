package ma.fiscacostra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fiscacostra.enums.TypeQuestion;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Reponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reponse;

    private TypeQuestion type;


    @JsonIgnore
    @ManyToOne
    private Question question;


    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Reponse parent;
}
