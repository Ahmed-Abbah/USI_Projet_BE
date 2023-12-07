package ma.fiscacostra.services;


import ma.fiscacostra.dtos.QuestionRequest;
import ma.fiscacostra.dtos.QuestionResponse;
import ma.fiscacostra.dtos.ReponseRequest;
import ma.fiscacostra.dtos.ReponseResponse;
import ma.fiscacostra.entities.Question;
import ma.fiscacostra.entities.Reponse;
import ma.fiscacostra.enums.TypeQuestion;
import ma.fiscacostra.mappers.QuestionMapper;
import ma.fiscacostra.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


     public QuestionServiceImpl(QuestionRepository questionRepository, QuestionMapper questionMapper){
         this.questionRepository=questionRepository;
         this.questionMapper = questionMapper;
     }




     public List<QuestionResponse> findAll(){

         return this.questionRepository.findAll()
                 .stream()
                 .map(question -> this.questionMapper.questionToQuestionResponse(question))
                 .collect(Collectors.toList());
     }



     public QuestionResponse saveQuestion(QuestionRequest questionRequest){

         Question question = this.questionMapper.questionRequestToQuestion(questionRequest);
         question.setType(TypeQuestion.NEW);

         Question saveQuestion = this.questionRepository.save(question);

         return this.questionMapper.questionToQuestionResponse(saveQuestion);
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




}
