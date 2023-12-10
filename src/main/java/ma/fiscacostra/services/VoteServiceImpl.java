package ma.fiscacostra.services;


import ma.fiscacostra.dtos.VoteRequest;
import ma.fiscacostra.dtos.VoteResponse;
import ma.fiscacostra.entities.Question;
import ma.fiscacostra.entities.Vote;
import ma.fiscacostra.mappers.VoteMapper;
import ma.fiscacostra.repositories.QuestionRepository;
import ma.fiscacostra.repositories.ReponseRepository;
import ma.fiscacostra.repositories.UserRepository;
import ma.fiscacostra.repositories.VoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VoteServiceImpl implements VoteService {

    private  final VoteMapper voteMapper;
    private final VoteRepository voteRepository;

    private final QuestionRepository questionRepository;
    private final ReponseRepository reponseRepository;

    private final UserRepository userRepository;

    public VoteServiceImpl(VoteMapper voteMapper, VoteRepository voteRepository, QuestionRepository questionRepository, ReponseRepository reponseRepository, UserRepository userRepository) {
        this.voteMapper = voteMapper;
        this.voteRepository = voteRepository;
        this.questionRepository = questionRepository;
        this.reponseRepository = reponseRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Vote save(Vote vote) {
        return this.voteRepository.save(vote);
    }


    /**
     *
     * @param id du vote
     */
    @Override
    public VoteResponse updateVote(Long id) {

        /**____find user_____*/
        //User user = this.findUser(String email);
//        Optional<Question> optionalQuestion = this.questionRepository.findById(id);
//
//        if(optionalQuestion.isPresent()){
//            Question question = optionalQuestion.get();
//            List<Vote> questionVotes =  question.getVote();
//            Vote vote  = new Vote();
//
//        }

        /**_____Save Vote_______*/
        Vote existingVote = this.voteRepository.findById(id).get();
        Vote updatedVote = this.voteRepository.save(existingVote);



        return this.voteMapper.voteToVoteResponse(updatedVote);

    }


//    private User findUser(String email){
//        return this.userRepository.findByEmail(email);;
//    }



}
