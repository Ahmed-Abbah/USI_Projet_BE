package ma.fiscacostra.dtos;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequest {
    private  Long id;
    private String question;
    private MetierRequest metier;
}
