package app.restaurant.services.user;

import app.restaurant.models.user.Roles;
import app.restaurant.models.user.User;
import app.restaurant.payload.request.SignupRequest;
import app.restaurant.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RolesService rolesService;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
    }

    @Override
    public Boolean cekExistsUserByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void createUser(SignupRequest signUpRequest) {
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Roles> roles = rolesService.assignRoles(strRoles);

        user.setRoles(roles);
        userRepository.save(user);
    }
}
