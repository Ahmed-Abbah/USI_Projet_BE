package ma.fiscacostra.mappers;


import ma.fiscacostra.dtos.VoteRequest;
import ma.fiscacostra.dtos.VoteResponse;
import ma.fiscacostra.entities.Vote;
import org.mapstruct.Mapper;



@Mapper(componentModel="spring")
public interface VoteMapper {
    
    VoteResponse voteToVoteResponse(Vote vote);
    Vote voteRequestToVote(VoteRequest voteRequest);
}
