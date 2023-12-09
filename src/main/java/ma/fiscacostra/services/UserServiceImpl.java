package ma.fiscacostra.services;


import ma.fiscacostra.dtos.UserRequest;
import ma.fiscacostra.dtos.UserResponse;
import ma.fiscacostra.entities.User;
import ma.fiscacostra.enums.Expert;
import ma.fiscacostra.enums.Role;
import ma.fiscacostra.mappers.UserMapper;
import ma.fiscacostra.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


        User existingUser = this.userRepository.findByEmail(userRequest.getEmail());

        if(existingUser==null){

            PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
            userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));


            User savingUser = this.userMapper.userRequestToUser(userRequest);
            User savedUser = this.userRepository.save(savingUser);

            UserResponse userResponse =  this.userMapper.userToUserResponse(savedUser);
            userResponse.setExits(false);
            return  userResponse;

        }else {
            UserResponse userResponse = userMapper.userToUserResponse(existingUser);
            userResponse.setExits(true);
            return  userResponse;
        }

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



    @Override
    public List<UserResponse> getAllExperts(Pageable pageable) {
        Page<User> users = this.userRepository.findAllByExpert(pageable, Expert.OUI);

        List<UserResponse> userResponses = users
                .stream()
                .map(user -> this.userMapper.userToUserResponse(user))
                .collect(Collectors.toList());

        return userResponses;
    }


    @Override
    public List<UserResponse> getAllEmployees(Pageable pageable) {
        Page<User> users = this.userRepository.findAllByRole(pageable, Role.EMPLOYEE);

        List<UserResponse> userResponses = users
                .stream()
                .map(user -> this.userMapper.userToUserResponse(user))
                .collect(Collectors.toList());

        return userResponses;
    }
}
