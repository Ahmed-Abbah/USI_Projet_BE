package ma.fiscacostra.services;

import ma.fiscacostra.dtos.ReponseResponse;
import ma.fiscacostra.dtos.ReponseRequest;

public interface ReponseService {

    /** email pour la securite apres apres */
    ReponseResponse saveResponse(Long id,ReponseRequest reponseRequest);



    /** email pour la securite apres apres */
    ReponseResponse saveSubResponse(Long id_p,Long id_q, ReponseRequest reponseRequest);

    /** email pour la securite apres apres */
    ReponseResponse update(Long id,ReponseRequest reponseRequest);

    /** email pour la securite apres apres */

    void delete(Long id);

}
