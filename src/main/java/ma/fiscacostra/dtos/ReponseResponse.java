package ma.fiscacostra.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;
import ma.fiscacostra.entities.User;

import java.util.Date;
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

    private Date date;
}
