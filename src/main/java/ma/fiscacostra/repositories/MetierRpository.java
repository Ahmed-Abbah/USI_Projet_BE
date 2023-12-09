package ma.fiscacostra.repositories;

import ma.fiscacostra.entities.Metier;
import ma.fiscacostra.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetierRpository extends JpaRepository<Metier, Long> {


    Metier findByNom(String nom);
}
