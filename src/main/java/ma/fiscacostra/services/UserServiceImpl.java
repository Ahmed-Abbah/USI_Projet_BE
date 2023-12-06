package ma.fiscacostra.services;


import ma.fiscacostra.dtos.UserRequest;
import ma.fiscacostra.dtos.UserResponse;
import ma.fiscacostra.entities.User;
import ma.fiscacostra.mappers.UserMapper;
import ma.fiscacostra.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }



    @Override
    public UserResponse saveUser(UserRequest userRequest) {

        User savingUser = this.userMapper.userRequestToUser(userRequest);
        User savedUser = this.userRepository.save(savingUser);


        return  this.userMapper.userToUserResponse(savedUser);

    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {

        User existingUser = this.userRepository.findById(id).get();
        User sendedUser = this.userMapper.userRequestToUser(userRequest);

        existingUser.setPrenom(sendedUser.getPrenom());
        existingUser.setNom(sendedUser.getNom());
        existingUser.setEmail(sendedUser.getEmail());
        existingUser.setPassword(sendedUser.getPassword());
        existingUser.setRole(sendedUser.getRole());
        existingUser.setFonction(sendedUser.getFonction());


        User updatedUser = this.userRepository.save(sendedUser);
        return this.userMapper.userToUserResponse(updatedUser);
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }
}
