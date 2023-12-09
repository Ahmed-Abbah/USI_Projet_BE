package ma.fiscacostra.dtos;


import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fiscacostra.entities.Question;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetierRequest {

    private Long id;
    private  String nom;
    private String description;
}
