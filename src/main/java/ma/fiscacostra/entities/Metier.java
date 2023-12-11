package ma.fiscacostra.entities;




import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Metier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nom;

    @Column(columnDefinition = "TEXT")
    private String description;
    @OneToMany(mappedBy = "metier", fetch = FetchType.EAGER)
    private List<Question> questions;
}
