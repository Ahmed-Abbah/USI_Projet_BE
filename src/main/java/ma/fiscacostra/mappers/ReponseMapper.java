package ma.fiscacostra.mappers;


import ma.fiscacostra.dtos.QuestionRequest;
import ma.fiscacostra.dtos.QuestionResponse;
import ma.fiscacostra.dtos.ReponseRequest;
import ma.fiscacostra.dtos.ReponseResponse;
import ma.fiscacostra.entities.Question;
import ma.fiscacostra.entities.Reponse;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface ReponseMapper {
    ReponseResponse reponseToReponseResponse(Reponse reponse);
    Reponse ReponseRequestToReponse(ReponseRequest reponseRequest);
}
