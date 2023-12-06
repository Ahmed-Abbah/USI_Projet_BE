package ma.fiscacostra.repositories;

import ma.fiscacostra.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
