package ma.fiscacostra.services;

import ma.fiscacostra.dtos.ReponseRequest;
import ma.fiscacostra.dtos.ReponseResponse;
import ma.fiscacostra.dtos.UserRequest;
import ma.fiscacostra.dtos.UserResponse;
import ma.fiscacostra.entities.User;

public interface UserService {


    /** email pour la securite apres apres */
    UserResponse saveUser(UserRequest userRequest);

    /** email pour la securite apres apres */
    UserResponse update(Long id, UserRequest userRequest);

    /** email pour la securite apres apres */
    void delete(Long id);

}
