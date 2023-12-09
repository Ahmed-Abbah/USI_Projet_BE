package ma.fiscacostra.services;


import ma.fiscacostra.dtos.MetierResponse;

import ma.fiscacostra.dtos.VoteRequest;
import ma.fiscacostra.dtos.VoteResponse;
import ma.fiscacostra.entities.Vote;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MetierService {
    /** email pour la securite apres apres */
    List<MetierResponse> getAll(Pageable pageable);
}
