package info.civa86.authservice.service;

import info.civa86.authservice.model.CustomUserDetails;
import info.civa86.authservice.model.Users;
import info.civa86.authservice.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Users> usersOptional = usersRepository.findByEmail(email);

        usersOptional.orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        return usersOptional.map(CustomUserDetails::new).get();
    }
}
