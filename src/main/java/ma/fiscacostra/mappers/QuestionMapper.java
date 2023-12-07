package ma.fiscacostra.mappers;


import ma.fiscacostra.dtos.QuestionRequest;
import ma.fiscacostra.dtos.QuestionResponse;
import ma.fiscacostra.entities.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface QuestionMapper {

    QuestionResponse questionToQuestionResponse(Question question);
    Question questionRequestToQuestion(QuestionRequest questionRequest);
}
