package ma.fiscacostra.repositories;

import ma.fiscacostra.entities.User;
import ma.fiscacostra.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
