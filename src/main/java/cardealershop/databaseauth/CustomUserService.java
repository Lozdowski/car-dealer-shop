package cardealershop.databaseauth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomUserService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserService(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<UserApp> userApp = userRepository.findUserAppByLogin(login);
        userApp.orElseThrow(() -> new UsernameNotFoundException("user by login: "+login+ " not found!"));
        return userApp.map(CustomUserDetails::new).get();
    }
}
