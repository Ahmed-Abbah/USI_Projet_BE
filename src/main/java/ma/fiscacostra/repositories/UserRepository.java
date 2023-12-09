package ma.fiscacostra.repositories;

import ma.fiscacostra.entities.User;
import ma.fiscacostra.enums.Expert;
import ma.fiscacostra.enums.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    Page<User> findAllByExpert(Pageable pageable, Expert oui);

    Page<User> findAllByRole(Pageable pageable, Role employee);
}

