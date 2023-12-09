package ma.fiscacostra.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
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
