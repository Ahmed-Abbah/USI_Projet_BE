package ma.fiscacostra.services;


import ma.fiscacostra.entities.Question;
import ma.fiscacostra.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
     private QuestionRepository questionRepository;

     @Autowired
     public QuestionServiceImpl(QuestionRepository questionRepository){
         this.questionRepository=questionRepository;
     }

     public List<Question> findAll(){
         return this.questionRepository.findAll();
     }

     public Question saveQuestion(Question question){
        return this.questionRepository.save(question);
    }

     public boolean deleteQuestion(long id){
         Optional<Question> question = this.questionRepository.findById(id);
        if(question.isPresent()){
            this.questionRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
     }

     public Optional<Question> findQuestionById(Long id){
         return this.questionRepository.findById(id);
     }
}
