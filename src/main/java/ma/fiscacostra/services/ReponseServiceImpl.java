package ma.fiscacostra.services;


import ma.fiscacostra.dtos.ReponseRequest;
import ma.fiscacostra.dtos.ReponseResponse;
import ma.fiscacostra.entities.Question;
import ma.fiscacostra.entities.Reponse;
import ma.fiscacostra.entities.User;
import ma.fiscacostra.entities.Vote;
import ma.fiscacostra.mappers.ReponseMapper;
import ma.fiscacostra.repositories.QuestionRepository;
import ma.fiscacostra.repositories.ReponseRepository;
import ma.fiscacostra.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReponseServiceImpl implements ReponseService {


    private final ReponseRepository reponseRepository;
    private final ReponseMapper reponseMapper;
    private final UserRepository userRepository;

    private final QuestionRepository questionRepository;

    private final VoteService voteService;

    public ReponseServiceImpl(ReponseRepository reponseRepository, ReponseMapper reponseMapper, UserRepository userRepository, QuestionRepository questionRepository, VoteService voteService) {
        this.reponseRepository = reponseRepository;
        this.reponseMapper = reponseMapper;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.voteService = voteService;
    }




    /**
     * @param id de la question
     */
    @Override
    public ReponseResponse saveResponse(Long id, ReponseRequest reponseRequest, String email) {

        /**____find user____*/
        User user = this.findUser(email);

        /**____find Question__*/
        Question question = this.findQuestion(id);

//        /**___define vote______*/
//        Vote vote = new Vote();
//        vote.setNbreVote(0);
//        vote.setQuestion(question);
//        vote.setUser(vote);
//        Vote savedVote = this.voteService.save(vote);

        /**___Save Reponse______*/
        Reponse savingReponse= this.reponseMapper.ReponseRequestToReponse(reponseRequest);


        savingReponse.setParent(null);
        savingReponse.setQuestion(question);
        savingReponse.setUser(user);
//        List<Vote> votes = new ArrayList<>();
//        votes.add(vote);
//        savingReponse.setVote(votes);

        Reponse savedReponse = this.reponseRepository.save(savingReponse);

//        /**___Update Vote______*/
//        savedVote.setReponse(savedReponse);
//        Vote updatedVote  = this.voteService.save(savedVote);

        return this.reponseMapper.reponseToReponseResponse(savedReponse);
    }



//
//    /**
//     * @param id_p de la reponse parente
//     * @param id_q de la question
//     */
    @Override
    public ReponseResponse saveSubResponse(Long id_p, Long id_q, ReponseRequest reponseRequest) {

//        /**____find user_______*/
//        //User user = this.findUser(String email);
//
//        /**____find Parent______*/
//        Reponse parent = this.findReponse(id_p);
//
//        /**_____find Question_____*/
//        Question question = this.findQuestion(id_q);
//
//        /**___define vote______*/
//        Vote vote = new Vote();
//        vote.setNbreVote(0);
//        vote.setQuestion(question);
//        //vote.setUser(vote);
//
//        Vote savedVote = this.voteService.save(vote);
//
//        /**____Save SubReponse______*/
//
//        Reponse savingReponse= this.reponseMapper.ReponseRequestToReponse(reponseRequest);
//
//        savingReponse.setParent(parent);
//        savingReponse.setEnfants(null);
//        savingReponse.setQuestion(question);
//        //savingReponse.setUser(user);
//        List<Vote> votes = new ArrayList<>();
//        votes.add(vote);
//        savingReponse.setVote(votes);
//
//        Reponse savedReponse = this.reponseRepository.save(savingReponse);
//
//
//        /**___Update Parent______*/
//        parent.getEnfants().add(savedReponse);
//        this.reponseRepository.save(parent);
//
//
//
//        /**___Update Vote______*/
//        savedVote.setReponse(savedReponse);
//        Vote updatedVote  = this.voteService.save(savedVote);
//
//        return this.reponseMapper.reponseToReponseResponse(savedReponse);

        return null;

    }




    @Override
    public ReponseResponse update(Long id, ReponseRequest reponseRequest) {

        Reponse existingReponse  = this.reponseRepository.findById(id).get();
        Reponse sendedReponse = this.reponseMapper.ReponseRequestToReponse(reponseRequest);

        existingReponse.setReponse(sendedReponse.getReponse());
        Reponse updatedReponse = this.reponseRepository.save(existingReponse);

        return reponseMapper.reponseToReponseResponse(updatedReponse);
    }



    @Override
    public boolean delete(Long id) {

        Optional<Reponse> reponseOptional = this.reponseRepository.findById(id);

        if(reponseOptional.isPresent()){

            Reponse reponse = reponseOptional.get();
            
            if (reponse.getParent() != null) {
                reponse.getParent().getEnfants().remove(reponse);
            }

            if (reponse.getEnfants() != null) {
                for (Reponse enfant : reponse.getEnfants()) {
                    enfant.setParent(null);
                    this.reponseRepository.delete(enfant);
                }
            }



            /**La suppression*/
            this.reponseRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }




    private User findUser(String email){
        return this.userRepository.findByEmail(email);
    }

    private Question findQuestion(Long id){
        return this.questionRepository.findById(id).get();
    }

    private Reponse findReponse(Long id){
        return this.reponseRepository.findById(id).get();
    }




}
