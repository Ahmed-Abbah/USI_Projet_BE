package ma.fiscacostra.web;


import lombok.AllArgsConstructor;
import ma.fiscacostra.dtos.VoteRequest;
import ma.fiscacostra.dtos.VoteResponse;
import ma.fiscacostra.services.VoteService;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
@CrossOrigin("*")
public class VoteController {
    private final VoteService voteService;

    private final JwtDecoder jwtDecoder;

    @PutMapping("/vote")
    public void voteResponse(@RequestParam(name = "id") Long questionId,
                             @RequestHeader("Authorization") String jwtToken){
        String token = jwtToken.replace("Bearer ", "");
        Jwt jwt = this.jwtDecoder.decode(token);
        String email = jwt.getSubject();
        this.voteService.updateVote(questionId,email);
    }


}
