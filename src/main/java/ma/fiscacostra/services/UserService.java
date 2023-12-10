package ma.fiscacostra.services;

import ma.fiscacostra.dtos.*;
import ma.fiscacostra.entities.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {


    /** email pour la securite apres apres */
    UserResponse saveUser(UserRequest userRequest);

    /** email pour la securite apres apres */
    UserResponse update(Long id, UserRequest userRequest);

    /** email pour la securite apres apres */
    void delete(Long id);



    /** email pour la securite apres apres */
    List<UserResponse> getAllExperts(Pageable pageable);


    /** email pour la securite apres apres */
    List<UserResponse> getAllEmployees(Pageable pageable);

    UserResponse updateExpert(Long id);


}
