package ma.fiscacostra.dtos;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoteRequest {
    private Long id;
    private int nbreVote;
}
