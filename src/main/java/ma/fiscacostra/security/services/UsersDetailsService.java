//package ma.fiscacostra.security.services;
//
//
//import ma.fiscacostra.entities.User;
//import ma.fiscacostra.repositories.UserRepository;
//import ma.fiscacostra.security.utils.UsersDetails;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UsersDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public UsersDetailsService(UserRepository userRepository) {
//        super();
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user = this.userRepository.findByEmail(username);
//        if(user==null) {
//            throw new UsernameNotFoundException("Email ou mot de passe incorrect");
//        }
//        return  new UsersDetails(user);
//    }
//}
