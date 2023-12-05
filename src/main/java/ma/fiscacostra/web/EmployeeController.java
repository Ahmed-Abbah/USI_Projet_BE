package ma.fiscacostra.web;


import lombok.AllArgsConstructor;
import ma.fiscacostra.dtos.ReponseRequest;
import ma.fiscacostra.dtos.ReponseResponse;
import ma.fiscacostra.services.ReponseService;
import ma.fiscacostra.services.VoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final ReponseService reponseService;




    /****************************************** La partie aux reponses ************************************/
    @PostMapping("/reponse/{id}")
    public ReponseService addReponse(@RequestBody ReponseRequest reponseRequest,
                                     @PathVariable Long id){
        ReponseResponse reponseResponse = this.reponseService.saveResponse(id,reponseRequest);
        return reponseService;
    }


    /***************************** Les methodes specifiques aux sous reponses *****************************/
    @PostMapping("/sousreponse/{id_p}/{id_q}")
    public ReponseService addSubReponse(@RequestBody ReponseRequest reponseRequest,
                                     @PathVariable Long id_p,@PathVariable Long id_q){
        ReponseResponse reponseResponse = this.reponseService.saveSubResponse(id_p,id_q,reponseRequest);
        return reponseService;
    }




    /****************************** Les methodes  communes ************************************************/
    @PutMapping("/reponse/{id}")
    public ReponseService updateReponse(@RequestBody ReponseRequest reponseRequest,
                                     @PathVariable Long id){
        ReponseResponse reponseResponse = this.reponseService.update(id,reponseRequest);
        return reponseService;
    }


    @DeleteMapping("/reponse/{id}")
    public void deleteReponse(@PathVariable Long id){
        this.reponseService.delete(id);
    }




}
