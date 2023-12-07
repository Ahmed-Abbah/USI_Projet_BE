package ma.fiscacostra.web;


import lombok.AllArgsConstructor;
import ma.fiscacostra.dtos.QuestionRequest;
import ma.fiscacostra.dtos.QuestionResponse;
import ma.fiscacostra.entities.Question;
import ma.fiscacostra.entities.User;
import ma.fiscacostra.enums.TypeQuestion;
import ma.fiscacostra.services.QuestionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionServiceImpl questionService;

    @GetMapping
    public List<QuestionResponse> listQuestions() {
        return questionService.findAll();
    }



    @PostMapping
    public QuestionResponse saveQuestion(@RequestBody QuestionRequest questionRequest) {
        return questionService.saveQuestion(questionRequest);
    }


    @PutMapping("/{questionId}")
    public QuestionResponse modifyQuestion(@PathVariable Long questionId,
                                           @RequestBody QuestionRequest questionRequest) {
        return this.questionService.update(questionId, questionRequest);
    }




    @DeleteMapping("/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long questionId) {

        if(this.questionService.deleteQuestion(questionId)){
            System.out.println("Question with ID " + questionId + " has been deleted.");
            return new ResponseEntity<>("Question with ID " + questionId + " has been deleted.", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Question with ID " + questionId + " not found.", HttpStatus.NOT_FOUND);
        }
    }




}
