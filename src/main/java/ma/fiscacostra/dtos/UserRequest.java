package ma.fiscacostra.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fiscacostra.enums.Expert;
import ma.fiscacostra.enums.Fonction;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private Long id;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private Fonction fonction;

    private Expert expert;
}
