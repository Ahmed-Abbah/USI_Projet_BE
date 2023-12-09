package ma.fiscacostra.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fiscacostra.entities.Reponse;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReponseResponse {
    private Long id;
    private String reponse;
    private ReponseResponse parent;
    private List<ReponseResponse> enfants;
}
