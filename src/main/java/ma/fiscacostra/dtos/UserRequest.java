package ma.fiscacostra.dtos;

import lombok.*;
import ma.fiscacostra.enums.Expert;
import ma.fiscacostra.enums.Fonction;


@Getter
@Setter
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
