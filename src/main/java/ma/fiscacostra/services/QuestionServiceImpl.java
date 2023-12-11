package ma.fiscacostra.services;


import ma.fiscacostra.dtos.QuestionRequest;
import ma.fiscacostra.dtos.QuestionResponse;
import ma.fiscacostra.entities.Metier;
import ma.fiscacostra.entities.Question;
import ma.fiscacostra.entities.User;
import ma.fiscacostra.enums.TypeQuestion;
import ma.fiscacostra.mappers.QuestionMapper;
import ma.fiscacostra.repositories.MetierRpository;
import ma.fiscacostra.repositories.QuestionRepository;
import ma.fiscacostra.repositories.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {


     private final QuestionRepository questionRepository;
     private final QuestionMapper questionMapper;

    private final UserRepository userRepository;
    private final MetierRpository metierRpository;


     public QuestionServiceImpl(QuestionRepository questionRepository, QuestionMapper questionMapper, UserRepository userRepository, MetierRpository metierRpository){
         this.questionRepository=questionRepository;
         this.questionMapper = questionMapper;
         this.userRepository = userRepository;
         this.metierRpository = metierRpository;
     }

     public QuestionResponse findQuestionById(Long id){
         Optional<Question> question = this.questionRepository.findById(id);
         if(question.isPresent()){
             return this.questionMapper.questionToQuestionResponse(question.get());
         }
         return null;
     }




     public List<QuestionResponse> findAll(){

         return this.questionRepository.findAll()
                 .stream()
                 .map(question -> this.questionMapper.questionToQuestionResponse(question))
                 .collect(Collectors.toList());
     }


    public List<QuestionResponse> findAllByMetier(String nom){

        System.out.println("1ere appelation!!!!!");
        System.out.println("Nom meteir : " + nom);
        List<QuestionResponse> questionResponses = this.questionRepository.findAllByMetier_Nom(nom)
                .stream()
                .map(question -> this.questionMapper.questionToQuestionResponse(question))
                .collect(Collectors.toList());
//        System.out.println(questionResponses);
        System.out.println("2eme appelation!!!!!");



        return questionResponses;
    }


     public QuestionResponse saveQuestion(QuestionRequest questionRequest, String email){


         /**____find user_______*/
         User user = this.findUser(email);


         /**_____find Metier________*/
         Metier metier = findMetier(questionRequest.getMetier().getNom());


         if(metier != null){

             Question question = this.questionMapper.questionRequestToQuestion(questionRequest);

             question.setType(TypeQuestion.NEW);
             question.setUser(user);
             question.setMetier(metier);


             Question savedQuestion = this.questionRepository.save(question);


             /**_____update Metier________*/
             metier.getQuestions().add(savedQuestion);
             this.metierRpository.save(metier);

             return this.questionMapper.questionToQuestionResponse(savedQuestion);

         }else {
             System.out.println("le metier n'existe pas!!!");

             return null;
         }

    }





     public boolean deleteQuestion(Long id){
         Optional<Question> question = this.questionRepository.findById(id);
        if(question.isPresent()){
            this.questionRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
     }




    public QuestionResponse update(Long id, QuestionRequest questionRequest) {

        Question existingQuestion  = this.questionRepository.findById(id).get();
        Question sendedQuestion = this.questionMapper.questionRequestToQuestion(questionRequest);

        existingQuestion.setQuestion(sendedQuestion.getQuestion());

        Question updatedQuestion = this.questionRepository.save(existingQuestion);

        return this.questionMapper.questionToQuestionResponse(updatedQuestion);
    }

    private User findUser(String email){
        return this.userRepository.findByEmail(email);
    }

    private Metier findMetier(String nom){
        return this.metierRpository.findByNom(nom);
    }



}
