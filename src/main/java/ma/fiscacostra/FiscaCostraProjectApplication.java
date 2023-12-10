package ma.fiscacostra;

import ma.fiscacostra.entities.Metier;
import ma.fiscacostra.entities.User;
import ma.fiscacostra.enums.Role;
import ma.fiscacostra.repositories.MetierRpository;
import ma.fiscacostra.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FiscaCostraProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiscaCostraProjectApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Bean
    CommandLineRunner run(UserRepository userRepository, PasswordEncoder passwordEncoder){
        return args -> {
            if(userRepository.findByEmail("admin@admin.com") != null) return;
            User admin = new User();
            admin.setEmail("admin@admin.com");
            admin.setPrenom("Abbah");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setNom("Ahmed");
            admin.setRole(Role.ADMIN);
            userRepository.save(admin);
        };
    }

    @Bean
    CommandLineRunner loadMetierData(MetierRpository metierRpository) {
        return args -> {
            // Check if Metier data already exists
            if (!metierRpository.findAll().isEmpty()) {
                return;
            }
            // Create a list of Metier names
            List<String> metierNames = Arrays.asList(
                    "Maçon",
                    "Charpentier",
                    "Couvreur",
                    "Plombier",
                    "Électricien du bâtiment",
                    "Monteur en isolation",
                    "Menuisier",
                    "Serrurier-métallier",
                    "Carreleur",
                    "Peintre en bâtiment",
                    "Grutier",
                    "Opérateur de machines de construction",
                    "Ingénieur en génie civil",
                    "Chef de chantier",
                    "Expert en sécurité sur les chantiers",
                    "Géomètre-topographe",
                    "Chef d'équipe",
                    "Technicien en génie civil",
                    "Opérateur de centrale à béton",
                    "Échafaudeur"
            );

            // Save Metier instances to the database
            metierNames.forEach(metierName -> {
                Metier metier = new Metier();
                metier.setNom(metierName);
                metierRpository.save(metier);
            });
        };
    }
}
