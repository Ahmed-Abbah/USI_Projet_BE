package ma.fiscacostra.repositories;

import ma.fiscacostra.entities.Question;
import ma.fiscacostra.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findByQuestion(Question question);
}
