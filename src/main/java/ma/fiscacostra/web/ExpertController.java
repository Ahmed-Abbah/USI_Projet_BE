package ma.fiscacostra.web;

import lombok.AllArgsConstructor;
import ma.fiscacostra.dtos.MetierResponse;
import ma.fiscacostra.dtos.UserResponse;
import ma.fiscacostra.services.MetierService;
import ma.fiscacostra.services.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@AllArgsConstructor
@RestController
@RequestMapping("/employee/experts")
@CrossOrigin("*")
public class ExpertController {


    private final UserService userService;

    private final int PAGE_SIZE = 16;


    @GetMapping
    List<UserResponse> getAll(@RequestParam(name = "page") int page){

        System.out.println("expert");
        Pageable pageable = PageRequest.of(page, this.PAGE_SIZE);
        return  this.userService.getAllExperts(pageable);
    }


}
