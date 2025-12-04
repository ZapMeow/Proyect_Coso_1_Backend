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

    // Registro con rol específico
    public User register(String username, String password, String role, String email, String typeUser, int points, String range, boolean isPremium) {
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .role(role != null ? role : "USER") // Por defecto USER
                .email(email)
                .typeUser(typeUser)
                .points(points)
                .range(range)
                .isPremium(isPremium)
                .build();
        return userRepository.save(user);
    }

    // Registro simple (siempre como USER)
    public User register(String username, String password, String email, String typeUser, int points, String range, boolean isPremium) {
        return register(username, password, "USER", email, typeUser, points, range, isPremium);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    //testing
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    public User updateUser(Long id, User updatedData) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(updatedData.getUsername());
        user.setEmail(updatedData.getEmail());
        user.setTypeUser(updatedData.getTypeUser());
        user.setPoints(updatedData.getPoints());
        user.setRange(updatedData.getRange());
        user.setPremium(updatedData.isPremium());

        return userRepository.save(user);
    }
}


