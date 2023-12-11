package ma.fiscacostra.dtos;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fiscacostra.entities.Reponse;
import ma.fiscacostra.entities.User;

import java.util.Date;
import java.util.List;

@Data
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
