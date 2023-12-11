package ma.fiscacostra.services;

import ma.fiscacostra.entities.Question;
import ma.fiscacostra.entities.User;
import ma.fiscacostra.entities.Vote;
import ma.fiscacostra.mappers.VoteMapper;
import ma.fiscacostra.repositories.QuestionRepository;
import ma.fiscacostra.repositories.ReponseRepository;
import ma.fiscacostra.repositories.UserRepository;
import ma.fiscacostra.repositories.VoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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

    @Override
    public void updateVote(Long questionId,String email) {
        Optional<Question> question = this.questionRepository.findById(questionId);
        if(question.isPresent()){
            Optional<Vote> vote = this.voteRepository.findByQuestion(question.get());
            if(vote.isPresent()){
                try{
                    Vote voteExistant = vote.get();

                    int voteCount = voteExistant.getNbreVote();
                    int voteIncremented = voteCount+1;
                    voteExistant.setNbreVote(voteIncremented);


                    //set the vote to the logged user
                    User user = this.userRepository.findByEmail(email);

                    voteExistant.getVotedUsers().add(user);
                    this.voteRepository.save(voteExistant);

                    user.getVote().add(voteExistant);

                    this.userRepository.save(user);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }else{

                Vote newVote = new Vote();
                newVote.setNbreVote(1);
                newVote.setQuestion(question.get());
                this.voteRepository.save(newVote);

                User user = this.userRepository.findByEmail(email);

                user.getVote().add(newVote);




                Set<User> users = new HashSet<>();
                users.add(user);

                newVote.setVotedUsers(users);

                this.userRepository.save(user);
                this.voteRepository.save(newVote);
            }
        }
    }


    /**
     *
     * @param id du vote
     */
//    @Override
//    public VoteResponse updateVote(Long id) {
//
//        /**____find user_____*/
//        //User user = this.findUser(String email);
////        Optional<Question> optionalQuestion = this.questionRepository.findById(id);
////
////        if(optionalQuestion.isPresent()){
////            Question question = optionalQuestion.get();
////            List<Vote> questionVotes =  question.getVote();
////            Vote vote  = new Vote();
////
////        }
//
//        /**_____Save Vote_______*/
//        Vote existingVote = this.voteRepository.findById(id).get();
//        Vote updatedVote = this.voteRepository.save(existingVote);
//
//
//
//        return this.voteMapper.voteToVoteResponse(updatedVote);
//
//    }
//    @Override
//    public void updateVote(Long questionId) {
//        /**____find user_____*/
//        //User user = this.findUser(String email);
//        /**_____Save Vote_______*/
//        Vote existingVote = this.voteRepository.findBy(id).get();
//        existingVote.setNbreVote(voteRequest.getNbreVote());
//        Vote updatedVote = this.voteRepository.save(existingVote);
//        return this.voteMapper.voteToVoteResponse(updatedVote);
//    }


//    private User findUser(String email){
//        return this.userRepository.findByEmail(email);;
//    }



}
