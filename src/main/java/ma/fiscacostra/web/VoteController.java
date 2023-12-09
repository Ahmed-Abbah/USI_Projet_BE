package ma.fiscacostra.web;


import lombok.AllArgsConstructor;
import ma.fiscacostra.dtos.VoteRequest;
import ma.fiscacostra.dtos.VoteResponse;
import ma.fiscacostra.services.VoteService;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
@CrossOrigin("*")
public class VoteController {
    private final VoteService voteService;

    private final JwtDecoder jwtDecoder;

    @PutMapping("/vote/{id}")
    public VoteResponse voteResponse(@RequestBody VoteRequest voteRequest,
                                     @PathVariable Long id){
        VoteResponse voteResponse = this.voteService.updateVote(id,voteRequest);
        return voteResponse;
    }


}
