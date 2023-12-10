package ma.fiscacostra.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.fiscacostra.enums.Expert;
import ma.fiscacostra.enums.Fonction;
import ma.fiscacostra.enums.Role;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String email;
    //private String password;
    private String nom;
    private String prenom;
    private Fonction fonction;
    private Role role;
    private Expert expert;
    private boolean isExits;

}
