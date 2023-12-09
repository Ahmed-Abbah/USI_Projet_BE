package ma.fiscacostra.repositories;

import ma.fiscacostra.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAllByMetier_Nom(String nom);

}


