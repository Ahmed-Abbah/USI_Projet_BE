package ma.fiscacostra.dtos;


import lombok.*;
import ma.fiscacostra.entities.Reponse;
import ma.fiscacostra.entities.User;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReponseResponse {
    private Long id;
    private String reponse;
    private ReponseResponse parent;
    private List<ReponseResponse> enfants;
    private User user;
}
