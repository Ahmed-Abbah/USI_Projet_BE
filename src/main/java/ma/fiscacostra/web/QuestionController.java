package ma.fiscacostra.web;


import lombok.AllArgsConstructor;
import ma.fiscacostra.dtos.QuestionRequest;
import ma.fiscacostra.dtos.QuestionResponse;
import ma.fiscacostra.services.QuestionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Logger;



@AllArgsConstructor
@RestController
@RequestMapping("/employee/question")
@CrossOrigin("*")
public class QuestionController {


    private QuestionServiceImpl questionService;


    private final JwtDecoder jwtDecoder;





    @GetMapping("/{questionId}")
    public QuestionResponse getQuestion(@PathVariable Long questionId) {
        return questionService.findQuestionById(questionId);
    }

    @GetMapping
    public List<QuestionResponse> listQuestions(@RequestParam(name = "nomMetier") String nomMetier) {
        if (nomMetier == "") {
            return questionService.findAll();
        }else {
            System.out.println("Metier nom :" + nomMetier);
            System.out.println("Premier appelation" + questionService.findAllByMetier(nomMetier));
            return questionService.findAllByMetier(nomMetier);
        }
    }


//    @GetMapping("/{nomMetier}")
//    public List<QuestionResponse> listQuestionsByMetier(@PathVariable String nomMetier) {
//
//        System.out.println("Metier nom :" + nomMetier);
//        System.out.println("Metier nom :" + nomMetier);
//        System.out.println("Metier nom :" + nomMetier);
//
//        System.out.println("Premier appelation" + questionService.findAllByMetier(nomMetier));
//        System.out.println("Premier appelation" + questionService.findAllByMetier(nomMetier));
//        System.out.println("Premier appelation" + questionService.findAllByMetier(nomMetier));
//
//        return questionService.findAllByMetier(nomMetier);
//    }



    @PostMapping
    public QuestionResponse saveQuestion(@RequestBody QuestionRequest questionRequest,
                                         @RequestHeader("Authorization") String jwtToken) {


        String token = jwtToken.replace("Bearer ", "");
        Jwt jwt = this.jwtDecoder.decode(token);
        String email = jwt.getSubject();

        questionRequest.setId(null);
        return questionService.saveQuestion(questionRequest, email);
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
