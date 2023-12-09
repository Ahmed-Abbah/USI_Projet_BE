package ma.fiscacostra.web;


import lombok.AllArgsConstructor;
import ma.fiscacostra.dtos.QuestionRequest;
import ma.fiscacostra.dtos.QuestionResponse;
import ma.fiscacostra.services.QuestionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Logger;



@AllArgsConstructor
@RestController
@RequestMapping("/employee/question")
@CrossOrigin("*")
public class QuestionController {
    private QuestionServiceImpl questionService;

    @GetMapping("/{questionId}")
    public QuestionResponse getQuestion(@PathVariable Long questionId) {
        return questionService.findQuestionById(questionId);
    }

    @GetMapping
    public List<QuestionResponse> listQuestions() {
        return questionService.findAll();
    }



    @PostMapping
    public QuestionResponse saveQuestion(@RequestBody QuestionRequest questionRequest) {
        questionRequest.setId(null);
        return questionService.saveQuestion(questionRequest);
    }


    @PutMapping("/{questionId}")
    public QuestionResponse modifyQuestion(@PathVariable Long questionId,@RequestBody QuestionRequest questionRequest) {
        return this.questionService.update(questionId, questionRequest);
    }



    @DeleteMapping("/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long questionId) {
        Logger logger = Logger.getLogger(getClass().getName());

        if (this.questionService.deleteQuestion(questionId)) {
            logger.info("Question with ID "+questionId+" has been deleted.");
            return new ResponseEntity<>("Question with ID " + questionId + " has been deleted.", HttpStatus.NO_CONTENT);
        } else {
            // Use java.util.logging.Logger for logging
            logger.warning("Question with ID "+questionId+" not found.");
            return new ResponseEntity<>("Question with ID " + questionId + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
