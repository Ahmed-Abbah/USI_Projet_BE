package ma.fiscacostra.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fiscacostra.entities.Question;
import ma.fiscacostra.enums.TypeQuestion;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepoonseRequest {
    private String reponse;
}
