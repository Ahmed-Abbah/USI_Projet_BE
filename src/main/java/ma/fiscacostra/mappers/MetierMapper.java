package ma.fiscacostra.mappers;

import ma.fiscacostra.dtos.MetierRequest;
import ma.fiscacostra.dtos.MetierResponse;
import ma.fiscacostra.dtos.QuestionRequest;
import ma.fiscacostra.dtos.QuestionResponse;
import ma.fiscacostra.entities.Metier;
import ma.fiscacostra.entities.Question;
import org.mapstruct.Mapper;


@Mapper(componentModel="spring")
public interface MetierMapper {
    MetierResponse metierToMetierResponse(Metier metier);
    Metier metierRequestToMetier(MetierRequest metierRequest);
}
