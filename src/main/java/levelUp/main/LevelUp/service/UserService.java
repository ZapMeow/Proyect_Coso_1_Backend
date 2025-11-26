package levelUp.main.LevelUp.service;

import levelUp.main.LevelUp.model.User;
import levelUp.main.LevelUp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User register(String username, String password){

        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();

        return userRepository.save(user);

    }

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
