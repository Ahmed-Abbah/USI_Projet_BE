package ma.fiscacostra.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
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

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> votedUsers;

}
