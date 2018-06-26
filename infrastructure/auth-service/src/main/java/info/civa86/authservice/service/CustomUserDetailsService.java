package info.civa86.authservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import info.civa86.authservice.model.CustomUserDetails;
import info.civa86.authservice.model.User;
import info.civa86.authservice.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> usersOptional = usersRepository.findByEmail(email);

        usersOptional.orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        return usersOptional.map(CustomUserDetails::new).get();
    }

    public Boolean isEmailAlreadyRegistered(String email) {
        Optional<User> userFound = usersRepository.findByEmail(email);
        return userFound.isPresent();
    }

    public void saveUser(User user) {
        usersRepository.save(user);
    }

}
