package ma.fiscacostra.web;

import lombok.AllArgsConstructor;
import ma.fiscacostra.dtos.*;
import ma.fiscacostra.services.MetierService;
import ma.fiscacostra.services.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@AllArgsConstructor
@RestController
@RequestMapping("/employee/expert")
@CrossOrigin("*")
public class ExpertController {


    private final UserService userService;

    private final int PAGE_SIZE = 16;

    private final JwtDecoder jwtDecoder;


    @GetMapping
    List<UserResponse> getAll(@RequestParam(name = "page") int page){

        System.out.println("expert");
        Pageable pageable = PageRequest.of(page, this.PAGE_SIZE);
        return  this.userService.getAllExperts(pageable);
    }


    @PutMapping("/{id}")
    public UserResponse voteResponse(@RequestBody UserRequest userRequest,
                                     @PathVariable Long id){
        UserResponse userResponse = this.userService.updateExpert(id);
        return userResponse;
    }


}
