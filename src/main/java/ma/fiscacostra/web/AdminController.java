package ma.fiscacostra.web;


import lombok.AllArgsConstructor;
import ma.fiscacostra.dtos.UserRequest;
import ma.fiscacostra.dtos.UserResponse;
import ma.fiscacostra.services.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/employee")
public class AdminController {


    private final UserService userService;

    private final int PAGE_SIZE = 10;

    private final JwtDecoder jwtDecoder;

    @GetMapping
    List<UserResponse> getAllEmployees(@RequestParam(name = "page") int page){
        System.out.println("employees");
        Pageable pageable = PageRequest.of(page, this.PAGE_SIZE);
        return  this.userService.getAllEmployees(pageable);
    }


    @PostMapping
    public UserResponse registerNewUser(@RequestBody UserRequest userRequest){

        userRequest.setId(null);
        UserResponse savedUser = userService.saveUser(userRequest);

        return savedUser;
    }



}
