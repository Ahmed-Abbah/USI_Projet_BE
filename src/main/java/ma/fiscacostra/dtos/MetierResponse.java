package ma.fiscacostra.dtos;


import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import ma.fiscacostra.entities.Question;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MetierResponse {
    private Long id;
    private  String nom;
    private String description;
    private List<QuestionResponse> questions;

}
