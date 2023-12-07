package ma.fiscacostra.mappers;



import ma.fiscacostra.dtos.UserRequest;
import ma.fiscacostra.dtos.UserResponse;
import ma.fiscacostra.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface UserMapper {

    UserResponse userToUserResponse(User user);
    User userRequestToUser(UserRequest userRequest);
}
