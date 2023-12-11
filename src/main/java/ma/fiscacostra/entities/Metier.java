package ma.fiscacostra.entities;


import jakarta.persistence.*;
import lombok.*;

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
