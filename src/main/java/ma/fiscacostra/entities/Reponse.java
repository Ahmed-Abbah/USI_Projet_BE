package ma.fiscacostra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ma.fiscacostra.enums.TypeQuestion;
import org.springframework.web.service.annotation.GetExchange;

import java.util.Date;
import java.util.List;


@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reponse;

    @JsonIgnore
    @ManyToOne
    private Question question;

    @JsonIgnore
    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Reponse parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Reponse> enfants;


//    @OneToMany(mappedBy = "reponse", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Vote> vote;


    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();



}
