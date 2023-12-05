package ma.fiscacostra.repositories;

import ma.fiscacostra.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
