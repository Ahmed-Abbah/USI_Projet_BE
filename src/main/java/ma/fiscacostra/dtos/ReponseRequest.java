package ma.fiscacostra.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToOne;
import lombok.*;
import ma.fiscacostra.entities.Question;
import ma.fiscacostra.enums.TypeQuestion;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReponseRequest {

    private Long id;
    private String reponse;
}
