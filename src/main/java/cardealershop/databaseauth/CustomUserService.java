package cardealershop.databaseauth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class CustomUserService implements UserDetailsService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    public CustomUserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<UserApp> userApp = userRepository.findUserAppByLogin(login);
        userApp.orElseThrow(() -> new UsernameNotFoundException("user by login: "+login+ " not found!"));
        return userApp.map(CustomUserDetails::new).get();
    }
    public UserApp registerUser(UserApp user) {
        Role role = roleRepository.findById(2); //USER
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);
        user.setRoles(roles);
        //  Set<UserApp> users = new HashSet<>();
        UserApp result = userRepository.save(user);
        // users.add(result);
        //  role.setUsers(users);
        // roleRepository.save(role);
        return result;
    }

}
