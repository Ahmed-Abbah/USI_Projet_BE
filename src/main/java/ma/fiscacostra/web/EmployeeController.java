package ma.fiscacostra.web;




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ma.fiscacostra.dtos.ReponseRequest;
import ma.fiscacostra.dtos.ReponseResponse;
import ma.fiscacostra.services.ReponseService;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {


    private final ReponseService reponseService;


    /****************************************** La partie aux reponses ************************************/
    @PostMapping("/reponse")
    public ReponseResponse addReponse(@RequestBody ReponseRequest reponseRequest,
                                     @RequestParam(name = "id") Long id){
        ReponseResponse reponseResponse = this.reponseService.saveResponse(id,reponseRequest);
        return reponseResponse;
    }


    /***************************** Les methodes specifiques aux sous reponses *****************************/
    @PostMapping("/sousreponse")
    public ReponseResponse addSubReponse(@RequestBody ReponseRequest reponseRequest,
                                        @RequestParam(name = "id_p") Long id_p,
                                        @RequestParam(name = "id_q") Long id_q){
        ReponseResponse reponseResponse = this.reponseService.saveSubResponse(id_p,id_q,reponseRequest);
        return reponseResponse;
    }




    /****************************** Les methodes  communes ************************************************/
    @PutMapping("/reponse/{id}")
    public ReponseResponse updateReponse(@RequestBody ReponseRequest reponseRequest,
                                     @PathVariable Long id){
        ReponseResponse reponseResponse = this.reponseService.update(id,reponseRequest);
        return reponseResponse;
    }


    @DeleteMapping("/reponse/{id}")
    public ResponseEntity<String> deleteReponse(@PathVariable Long id){

        if(this.reponseService.delete(id)){
            System.out.println("Reponse with ID " + id + " has been deleted.");
            return new ResponseEntity<>("Reponse with ID " + id + " has been deleted.", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Reponse with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }


    }



}
