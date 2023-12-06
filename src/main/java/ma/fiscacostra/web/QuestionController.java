package ma.fiscacostra.web;


import lombok.AllArgsConstructor;
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

    @GetMapping("/list")
    public ResponseEntity<List<Question>> listQuestions(@RequestBody Question question) {
        List<Question> questionList = questionService.findAll();
        return new ResponseEntity<>(questionList, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
        //TODO :: Specifier le type de la question ???
        System.out.println("Contenu du Question : "+question.getQuestion());
        System.out.println("Question Type : "+TypeQuestion.ETAPES_DE_LA_CONSTRUCTION);
        question.setType(String.valueOf(TypeQuestion.ETAPES_DE_LA_CONSTRUCTION));
        Question savedQuestion = questionService.saveQuestion(question);
        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long questionId) {
        if(this.questionService.deleteQuestion(questionId)){
            System.out.println("Question with ID " + questionId + " has been deleted.");
            return new ResponseEntity<>("Question with ID " + questionId + " has been deleted.", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Question with ID " + questionId + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/modify")
    public ResponseEntity<String> modifyQuestion(@RequestBody Question question) {
        Optional<Question> optionalQuestion = this.questionService.findQuestionById(question.getId());
        if(optionalQuestion.isPresent()){
            Question modifiedQuestion = optionalQuestion.get();
            modifiedQuestion.setQuestion(question.getQuestion());
            modifiedQuestion.setType(question.getType());
            // TODO :: get the logged user
            User user = new User();
            user.setId(1L);
            user.setNom("Ahmed");
            user.setPrenom("Abbah");
            user.setEmail("ahmed-abah@live.com");
            modifiedQuestion.setUser(user);
            this.questionService.saveQuestion(modifiedQuestion);
            System.out.println("Question with ID " + modifiedQuestion.getId() + " has been modified.");
            return new ResponseEntity<>("Question with ID " + modifiedQuestion.getId() + " has been modified.", HttpStatus.OK);
        }else{
            System.out.println("Question with ID " + question.getId() + " not found.");
            return new ResponseEntity<>("Question with ID " + question.getId() + " not found.", HttpStatus.NOT_FOUND);
        }
    }

}
