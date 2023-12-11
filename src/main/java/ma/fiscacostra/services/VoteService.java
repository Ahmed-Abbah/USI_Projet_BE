package ma.fiscacostra.services;


import ma.fiscacostra.dtos.VoteRequest;
import ma.fiscacostra.dtos.VoteResponse;
import ma.fiscacostra.entities.Vote;

public interface VoteService {

    Vote save(Vote vote);


    /** email pour la securite apres apres */
    void updateVote(Long questionId,String email);



}
